package rip.diamond.practice.profile;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import rip.diamond.practice.Eden;
import rip.diamond.practice.EdenItems;
import rip.diamond.practice.events.EdenEvent;
import rip.diamond.practice.kits.Kit;
import rip.diamond.practice.match.Match;
import rip.diamond.practice.party.Party;
import rip.diamond.practice.profile.data.ProfileKitData;
import rip.diamond.practice.profile.task.ProfileAutoSaveTask;
import rip.diamond.practice.util.Common;
import rip.diamond.practice.util.Cooldown;
import rip.diamond.practice.util.Tasks;
import rip.diamond.practice.util.VisibilityController;
import rip.diamond.practice.util.option.Option;

import java.util.*;
import java.util.function.Consumer;

@Getter
@RequiredArgsConstructor
public class PlayerProfile {

    @Getter private static final Map<UUID, PlayerProfile> profiles = Collections.synchronizedMap(new HashMap<>());

    private final UUID uniqueId;
    private final String username;
    private final Map<String, ProfileKitData> kitData = new HashMap<>();
    private final Map<ProfileSettings, Option> settings = new HashMap<>();
    private PlayerState playerState = PlayerState.LOADING;
    private final Map<String, Cooldown> cooldowns = new HashMap<>();
    @Setter private Match match;
    @Setter private Party party;

    private boolean saving = false;

    public static void init() {
        new ProfileAutoSaveTask();
    }

    public void fromBson(Document document) {
        Document settingsDocument = document.get("settings", Document.class);
        for (String data : settingsDocument.keySet()) {
            try {
                ProfileSettings s = ProfileSettings.valueOf(data);
                Option option = s.find(settingsDocument.getString(data));
                //This happens when the option value name is changed
                if (option == null) {
                    continue;
                }
                settings.put(s, option);
            } catch (IllegalArgumentException e) {
                Common.debug(username + " 的 SettingsDocument 裏面有不存在的 '" + data + "' 設定, 由於無法找到合適的設定, 所以已把它忽略");
            }
        }

        Document kitDataDocument = document.get("kitData", Document.class);
        for (String data : kitDataDocument.keySet()) {
            kitData.get(data).fromBson(kitDataDocument.get(data, Document.class));
        }
    }

    public Document toBson() {
        Document settingsDocument = new Document();
        for (Map.Entry<ProfileSettings, Option> options : settings.entrySet()) {
            settingsDocument.put(options.getKey().name(), options.getValue().getValue());
        }

        Document kitDataDocument = new Document();
        for (Map.Entry<String, ProfileKitData> kitDataMap : kitData.entrySet()) {
            kitDataDocument.put(kitDataMap.getKey(), kitDataMap.getValue().toBson());
        }

        //This document is temporary, meaning it is not going to load into profile, only for record purpose
        //This is mainly used to catch leaderboard data
        Document temporaryDocument = new Document()
                .append("globalElo", kitData.values().stream().mapToInt(ProfileKitData::getElo).sum() / (kitData.size() == 0 ? 1 : kitData.size()))
                ;
        //temporaryDocument End

        return new Document()
                .append("uuid", uniqueId.toString())
                .append("username", username)
                .append("lowerCaseUsername", username.toLowerCase())
                .append("settings", settingsDocument)
                .append("kitData", kitDataDocument)

                .append("temporary", temporaryDocument)
                ;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uniqueId);
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;

        VisibilityController.updateVisibility(getPlayer());
    }

    public void setupItems() {
        Player player = getPlayer();
        if (player == null) {
            return;
        }
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        if (playerState == PlayerState.IN_LOBBY) {
            if (Party.getByPlayer(player) == null) {
                EdenItems.giveItem(player, EdenItems.LOBBY_UNRANKED_QUEUE);
                EdenItems.giveItem(player, EdenItems.LOBBY_RANKED_QUEUE);
                if (EdenEvent.getOnGoingEvent() == null) {
                    EdenItems.giveItem(player, EdenItems.LOBBY_CREATE_EVENT);
                } else {
                    EdenItems.giveItem(player, EdenItems.LOBBY_JOIN_EVENT);
                }
                EdenItems.giveItem(player, EdenItems.LOBBY_PARTY_OPEN);
                EdenItems.giveItem(player, EdenItems.LOBBY_LEADERBOARD);
                EdenItems.giveItem(player, EdenItems.LOBBY_SETTINGS);
                EdenItems.giveItem(player, EdenItems.LOBBY_EDITOR);
            } else {
                EdenItems.giveItem(player, EdenItems.PARTY_PARTY_LIST);
                EdenItems.giveItem(player, EdenItems.PARTY_PARTY_FIGHT);
                EdenItems.giveItem(player, EdenItems.PARTY_OTHER_PARTIES);
                EdenItems.giveItem(player, EdenItems.PARTY_EDITOR);
                EdenItems.giveItem(player, EdenItems.PARTY_PARTY_LEAVE);
            }
        } else if (playerState == PlayerState.IN_QUEUE) {
            EdenItems.giveItem(player, EdenItems.QUEUE_LEAVE_QUEUE);
        } else if (playerState == PlayerState.IN_MATCH && match != null && !match.getTeamPlayer(getPlayer()).isAlive()) {
            EdenItems.giveItem(player, EdenItems.SPECTATE_TELEPORTER);
        } else if (playerState == PlayerState.IN_SPECTATING && match != null) {
            EdenItems.giveItem(player, EdenItems.SPECTATE_TELEPORTER);
            EdenItems.giveItem(player, EdenItems.SPECTATE_LEAVE_SPECTATE);
            EdenItems.giveItem(player, settings.get(ProfileSettings.SPECTATOR_VISIBILITY).isEnabled() ? EdenItems.SPECTATE_TOGGLE_VISIBILITY_OFF : EdenItems.SPECTATE_TOGGLE_VISIBILITY_ON);
        }
        player.updateInventory();
    }

    private void loadDefault() {
        Kit.getKits().forEach(kit -> kitData.putIfAbsent(kit.getName(), new ProfileKitData()));
    }

    private void loadDefaultAfter() {
        //Load it after, if I update the plugin and added a few new settings, then we will need this
        Arrays.asList(ProfileSettings.values()).forEach(profileSettings -> settings.putIfAbsent(profileSettings, profileSettings.getDefault()));
    }

    public void load(Consumer<Boolean> callback) {
        if (playerState != PlayerState.LOADING) {
            return;
        }
        Tasks.runAsync(()-> {
            try {
                loadDefault();

                Document document = Eden.INSTANCE.getMongoManager().getProfiles().find(Filters.eq("uuid", uniqueId.toString())).first();
                //Document will be null if the player is new
                if (document != null) {
                    fromBson(document);
                }

                loadDefaultAfter();

                callback.accept(true);
            } catch (Exception e) {
                e.printStackTrace();
                callback.accept(false);
            }
        });
    }

    public void save(boolean async, Consumer<Boolean> callback) {
        if (async) {
            Tasks.runAsync(()-> save(callback));
            return;
        }
        save(callback);
    }

    private void save(Consumer<Boolean> callback) {
        try {
            saving = true;
            if (playerState != PlayerState.LOADING) {
                Eden.INSTANCE.getMongoManager().getProfiles().replaceOne(Filters.eq("uuid", uniqueId.toString()), toBson(), new ReplaceOptions().upsert(true));
            }
            callback.accept(true);
            saving = false;
        } catch (Exception e) {
            e.printStackTrace();
            callback.accept(false);
        }
    }

    public static PlayerProfile get(Player player) {
        return get(player.getUniqueId());
    }
    public static PlayerProfile get(UUID uuid) {
        return profiles.get(uuid);
    }
    public static PlayerProfile createPlayerProfile(Player player) {
        PlayerProfile profile = new PlayerProfile(player.getUniqueId(), player.getName());
        profiles.put(player.getUniqueId(), profile);
        return profile;
    }
    public static PlayerProfile createPlayerProfile(UUID uuid, String username) {
        PlayerProfile profile = new PlayerProfile(uuid, username);
        profiles.put(uuid, profile);
        return profile;
    }

}
