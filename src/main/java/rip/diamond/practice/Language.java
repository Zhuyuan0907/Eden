package rip.diamond.practice;

import lombok.AllArgsConstructor;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import rip.diamond.practice.util.CC;
import rip.diamond.practice.util.Checker;
import rip.diamond.practice.util.Common;
import rip.diamond.practice.util.Util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum Language {

    SCOREBOARD_TITLE("scoreboard.title"),
    SCOREBOARD_LOADING("scoreboard.loading"),
    SCOREBOARD_IN_LOBBY("scoreboard.in-lobby"),
    SCOREBOARD_IN_PARTY("scoreboard.in-party"),
    SCOREBOARD_IN_EDIT("scoreboard.in-edit"),
    SCOREBOARD_IN_QUEUE_UNRANKED("scoreboard.in-queue-unranked"),
    SCOREBOARD_IN_QUEUE_RANKED("scoreboard.in-queue-ranked"),
    SCOREBOARD_IN_MATCH_SOLO_FIGHTING("scoreboard.in-match-solo.fighting"),
    SCOREBOARD_IN_MATCH_SOLO_BOXING("scoreboard.in-match-solo.boxing"),
    SCOREBOARD_IN_MATCH_SOLO_BED("scoreboard.in-match-solo.bed"),
    SCOREBOARD_IN_MATCH_SOLO_POINT("scoreboard.in-match-solo.point"),
    SCOREBOARD_IN_MATCH_SOLO_ENDING("scoreboard.in-match-solo.ending"),
    SCOREBOARD_IN_MATCH_TEAMS_FIGHTING("scoreboard.in-match-teams.fighting"),
    SCOREBOARD_IN_MATCH_TEAMS_BOXING("scoreboard.in-match-teams.boxing"),
    SCOREBOARD_IN_MATCH_TEAMS_BED("scoreboard.in-match-teams.bed"),
    SCOREBOARD_IN_MATCH_TEAMS_POINT("scoreboard.in-match-teams.point"),
    SCOREBOARD_IN_MATCH_TEAMS_ENDING("scoreboard.in-match-teams.ending"),
    SCOREBOARD_IN_MATCH_FFA_FIGHTING("scoreboard.in-match-ffa.fighting"),
    SCOREBOARD_IN_MATCH_FFA_ENDING("scoreboard.in-match-ffa.ending"),
    SCOREBOARD_IN_SPECTATE_SOLO_FIGHTING("scoreboard.in-spectate-solo.fighting"),
    SCOREBOARD_IN_SPECTATE_SOLO_BOXING("scoreboard.in-spectate-solo.boxing"),
    SCOREBOARD_IN_SPECTATE_SOLO_BED("scoreboard.in-spectate-solo.bed"),
    SCOREBOARD_IN_SPECTATE_SOLO_POINT("scoreboard.in-spectate-solo.point"),
    SCOREBOARD_IN_SPECTATE_SOLO_ENDING("scoreboard.in-spectate-solo.ending"),
    SCOREBOARD_IN_SPECTATE_TEAMS_FIGHTING("scoreboard.in-spectate-teams.fighting"),
    SCOREBOARD_IN_SPECTATE_TEAMS_BOXING("scoreboard.in-spectate-teams.boxing"),
    SCOREBOARD_IN_SPECTATE_TEAMS_BED("scoreboard.in-spectate-teams.bed"),
    SCOREBOARD_IN_SPECTATE_TEAMS_POINT("scoreboard.in-spectate-teams.point"),
    SCOREBOARD_IN_SPECTATE_TEAMS_ENDING("scoreboard.in-spectate-teams.ending"),
    SCOREBOARD_IN_SPECTATE_FFA_FIGHTING("scoreboard.in-spectate-ffa.fighting"),
    SCOREBOARD_IN_SPECTATE_FFA_ENDING("scoreboard.in-spectate-ffa.ending"),
    JOIN_MESSAGE("join-message"),
    INVALID_SYNTAX("invalid-syntax"),
    LOCATION_NOT_FOUND("location-not-found"),
    NO_PERMISSION("no-permission"),
    ENABLED("enabled"),
    DISABLED("disabled"),
    CONFIRM_TITLE("confirm-title"),
    REACHED_BUILD_LIMIT("reached-build-limit"),
    ARENA_ALREADY_EXISTS("arena.exists"),
    ARENA_NOT_EXISTS("arena.not-exists"),
    ARENA_CREATED("arena.created"),
    ARENA_SUCCESSFULLY_SET("arena.successfully-set"),
    ARENA_SAVED("arena.saved"),
    ARENA_SAVED_ALL("arena.saved-all"),
    ARENA_CANNOT_SET_BECAUSE_CLONE_FOUND("arena.cannot-set-because-clone-found"),
    ARENA_GENERATE_DISPLAY("arena.generate.display"),
    ARENA_GENERATE_HOVER("arena.generate.hover"),
    ARENA_GENERATE_COPYING("arena.generate.copying"),
    ARENA_REMOVE_SUCCESS_MAIN("arena.remove.success-main"),
    ARENA_REMOVE_SUCCESS_DUPLICATE("arena.remove.success-duplicate"),
    ARENA_MENU_TITLE("arena.menu.title"),
    ARENA_MENU_ARENA_EDIT_NAME("arena.menu.arena-edit.name"),
    ARENA_MENU_ARENA_EDIT_LORE("arena.menu.arena-edit.lore"),
    ARENA_DETAILS_MENU_TITLE("arena.details-menu.title"),
    ARENA_DETAILS_MENU_DETAIL_NAME("arena.details-menu.detail.name"),
    ARENA_DETAILS_MENU_DETAIL_LORE("arena.details-menu.detail.lore"),
    ARENA_DETAILS_MENU_DETAIL_LORE_NOT_DUPLICATED("arena.details-menu.detail.lore-not-duplicated"),
    ARENA_DETAILS_MENU_DETAIL_LORE_CLICK_TO_DELETE("arena.details-menu.detail.click-to-delete"),
    ARENA_DETAILS_MENU_DETAIL_LORE_CLICK_TO_TELEPORT("arena.details-menu.detail.click-to-teleport"),
    ARENA_DETAILS_MENU_DETAIL_TELEPORTED("arena.details-menu.detail.teleported"),
    ARENA_DETAILS_MENU_CREATE_DUPLICATE_NAME("arena.details-menu.create-duplicate.name"),
    ARENA_DETAILS_MENU_CREATE_DUPLICATE_LORE("arena.details-menu.create-duplicate.lore"),
    ARENA_EDIT_MENU_TITLE("arena.edit-menu.title"),
    ARENA_EDIT_MENU_CLICK_TO_EDIT("arena.edit-menu.click-to-edit"),
    ARENA_EDIT_MENU_ALLOWED_KITS_NAME("arena.edit-menu.allowed-kits.name"),
    ARENA_EDIT_MENU_ALLOWED_KITS_DESCRIPTION("arena.edit-menu.allowed-kits.description"),
    ARENA_EDIT_MENU_A_POSITION_NAME("arena.edit-menu.a-position.name"),
    ARENA_EDIT_MENU_A_POSITION_DESCRIPTION("arena.edit-menu.a-position.description"),
    ARENA_EDIT_MENU_A_POSITION_ACTION_DESCRIPTION("arena.edit-menu.a-position.action-description"),
    ARENA_EDIT_MENU_B_POSITION_NAME("arena.edit-menu.b-position.name"),
    ARENA_EDIT_MENU_B_POSITION_DESCRIPTION("arena.edit-menu.b-position.description"),
    ARENA_EDIT_MENU_B_POSITION_ACTION_DESCRIPTION("arena.edit-menu.b-position.action-description"),
    ARENA_EDIT_MENU_MIN_NAME("arena.edit-menu.min.name"),
    ARENA_EDIT_MENU_MIN_DESCRIPTION("arena.edit-menu.min.description"),
    ARENA_EDIT_MENU_MAX_NAME("arena.edit-menu.max.name"),
    ARENA_EDIT_MENU_MAX_DESCRIPTION("arena.edit-menu.max.description"),
    ARENA_EDIT_MENU_BUILD_MAX_NAME("arena.edit-menu.build-max.name"),
    ARENA_EDIT_MENU_BUILD_MAX_DESCRIPTION("arena.edit-menu.build-max.description"),
    ARENA_EDIT_MENU_Y_LIMIT_NAME("arena.edit-menu.y-limit.name"),
    ARENA_EDIT_MENU_Y_LIMIT_DESCRIPTION("arena.edit-menu.y-limit.description"),
    ARENA_EDIT_MENU_CLONE_NAME("arena.edit-menu.clone.name"),
    ARENA_EDIT_MENU_CLONE_DESCRIPTION("arena.edit-menu.clone.description"),
    ARENA_EDIT_MENU_CLONE_ACTION_DESCRIPTION("arena.edit-menu.clone.action-description"),
    ARENA_EDIT_MENU_DELETE_NAME("arena.edit-menu.delete.name"),
    ARENA_EDIT_MENU_DELETE_DESCRIPTION("arena.edit-menu.delete.description"),
    ARENA_EDIT_MENU_DELETE_ACTION_DESCRIPTION("arena.edit-menu.delete.action-description"),
    ARENA_EDIT_MENU_DELETE_ACTION_DESCRIPTION_HAS_CLONE("arena.edit-menu.delete.action-description-has-clone"),
    ARENA_EDIT_MENU_SAVE_NAME("arena.edit-menu.save.name"),
    ARENA_EDIT_MENU_SAVE_ACTION_DESCRIPTION("arena.edit-menu.toggle.action-description"),
    ARENA_EDIT_MENU_TOGGLE_NAME("arena.edit-menu.toggle.name"),
    ARENA_EDIT_MENU_TOGGLE_DESCRIPTION("arena.edit-menu.toggle.action-description"),
    ARENA_EDIT_MENU_TOGGLE_NEED_RESTART("arena.edit-menu.toggle.not-restart"),
    ARENA_EDIT_MENU_TOGGLE_ACTION_DESCRIPTION("arena.edit-menu.toggle.action-description"),
    ARENA_EDIT_MENU_TOGGLE_ACTION_DESCRIPTION_NOT_FINISHED_SETUP("arena.edit-menu.toggle.action-description-not-finished-setup"),
    ARENA_EDIT_MENU_TOGGLE_ACTION_DESCRIPTION_NEED_RESTART("arena.edit-menu.toggle.action-description-need-restart"),
    ARENA_EDIT_MIN("arena.edit.min"),
    ARENA_EDIT_MAX("arena.edit.max"),
    ARENA_EDIT_Y_LIMIT("arena.edit.y-limit"),
    ARENA_EDIT_BUILD_MAX("arena.edit.build-max"),
    ARENA_EDIT_ALLOWED_KITS("arena.edit.allowed-kits"),
    ARENA_EDIT_ALLOWED_KITS_ADDED("arena.edit.allowed-kits-added"),
    ARENA_EDIT_ALLOWED_KITS_REMOVED("arena.edit.allowed-kits-removed"),
    ARENA_EDIT_CANNOT_EDIT_NOT_FINISHED_SETUP("arena.edit.cannot-edit-not-finished-setup"),
    ARENA_EDIT_CANNOT_EDIT_NEED_RESTART("arena.edit.cannot-edit-need-restart"),
    DUEL_CANNOT_FIND_PLAYER("duel.cannot-find-player"),
    DUEL_CANNOT_DUEL_SELF("duel.cannot-duel-self"),
    DUEL_CANNOT_DUEL_NOT_IN_PARTY("duel.cannot-duel-not-in-party"),
    DUEL_HAS_PENDING_DUEL_REQUEST("duel.has-pending-duel-request"),
    DUEL_INVALID_UUID("duel.invalid-uuid"),
    DUEL_INVALID_DUEL_REQUEST("duel.invalid-duel-request"),
    DUEL_HELP_MESSAGE("duel.help-message"),
    DUEL_CHOOSE_ARENA_MENU_NAME("duel.choose-arena-menu.name"),
    DUEL_CHOOSE_ARENA_MENU_BUTTON_NAME("duel.choose-arena-menu.button.name"),
    DUEL_CHOOSE_ARENA_MENU_BUTTON_LORE("duel.choose-arena-menu.button.lore"),
    DUEL_CHOOSE_KIT_MENU_NAME("duel.choose-kit-menu.name"),
    DUEL_CHOOSE_KIT_MENU_BUTTON_NAME("duel.choose-kit-menu.button.name"),
    DUEL_CHOOSE_KIT_MENU_BUTTON_LORE("duel.choose-kit-menu.button.lore"),
    DUEL_DUEL_REQUEST_CANNOT_FIND_TARGET("duel.duel-request.cannot-find-target"),
    DUEL_DUEL_REQUEST_DISPLAY_1V1("duel.duel-request.display-1v1"),
    DUEL_DUEL_REQUEST_DISPLAY_PARTY("duel.duel-request.display-party"),
    DUEL_DUEL_REQUEST_CLICK_TO_ACCEPT("duel.duel-request.click-to-accept"),
    DUEL_DUEL_REQUEST_CLICK_TO_ACCEPT_HOVER("duel.duel-request.click-to-accept-hover"),
    DUEL_DUEL_REQUEST_CLICK_TO_VIEW_PING("duel.duel-request.click-to-view-ping"),
    DUEL_DUEL_REQUEST_CLICK_TO_VIEW_PING_HOVER("duel.duel-request.click-to-view-ping-hover"),
    DUEL_DUEL_REQUEST_SUCCESS_1V1("duel.duel-request.success-1v1"),
    DUEL_DUEL_REQUEST_SUCCESS_PARTY("duel.duel-request.success-party"),
    DUEL_VERIFY_TARGET_NOT_FOUND("duel.verify.target-not-found"),
    DUEL_VERIFY_NEED_TO_BE_IN_LOBBY("duel.verify.need-to-be-in-lobby"),
    DUEL_VERIFY_TARGET_NEED_TO_BE_IN_LOBBY("duel.verify.target-need-to-be-in-lobby"),
    DUEL_VERIFY_TARGET_DUEL_REQUEST_DISABLED("duel.verify.target-duel-request-disabled"),
    DUEL_VERIFY_CANNOT_FIND_ARENA("duel.verify.cannot-find-arena"),
    DUEL_VERIFY_TARGET_IN_A_PARTY("duel.verify.target-in-a-party"),
    DUEL_VERIFY_TARGET_NOT_IN_A_PARTY("duel.verify.target-not-in-a-party"),
    DUEL_VERIFY_CANNOT_DUEL_SAME_PARTY("duel.verify.cannot-duel-same-party"),
    DUEL_VERIFY_PLAYER_NOT_IN_LOBBY("duel.verify.player-not-in-lobby"),
    HOOK_FOUND_CUSTOM_SPIGOT("hook.found-custom-spigot"),
    HOOK_CANNOT_FIND_CUSTOM_SPIGOT("hook.cannot-find-custom-spigot"),
    HOOK_ERROR_KNOCKBACK_NOT_FOUND("hook.error-knockback-not-found"),
    KIT_EDITOR_CANNOT_EDIT_WRONG_STATE("kit-editor.cannot-edit-wrong-state"),
    KIT_EDITOR_EXTRA_ITEM_MENU_NAME("kit-editor.extra-item-menu-name"),
    KIT_EDITOR_SAVE_MENU_NAME("kit-editor.save-menu.name"),
    KIT_EDITOR_SAVE_MENU_SAVE_LOADOUT_BUTTON_NAME("kit-editor.save-menu.save-loadout-button-name"),
    KIT_EDITOR_SAVE_MENU_LOAD_LOADOUT_BUTTON_NAME("kit-editor.save-menu.load-loadout-button-name"),
    KIT_EDITOR_SAVE_MENU_RENAME_LOADOUT_BUTTON_NAME("kit-editor.save-menu.rename-loadout-button-name"),
    KIT_EDITOR_SAVE_MENU_DELETE_LOADOUT_BUTTON_NAME("kit-editor.save-menu.delete-loadout-button-name"),
    KIT_EDITOR_SAVE_MENU_RENAME_INSTRUCTIONS("kit-editor.save-menu.rename-instructions"),
    KIT_EDITOR_SAVE_MENU_INVALID_CHARACTER("kit-editor.save-menu.invalid-character"),
    KIT_EDITOR_SELECT_KIT_MENU_NAME("kit-editor.select-kit-menu.name"),
    KIT_EDITOR_SELECT_KIT_MENU_BUTTON_NAME("kit-editor.select-kit-menu.button.name"),
    KIT_EDITOR_SELECT_KIT_MENU_BUTTON_LORE("kit-editor.select-kit-menu.button.lore"),
    KIT_EDITOR_CANNOT_USE_COMMAND_WHILE_EDITING("kit-editor.cannot-use-command-while-editing"),
    KIT_EDITOR_DISALLOW_EXTRA_ITEM("kit-editor.disallow-extra-item"),
    KIT_EDITOR_EDITOR_LOCATION_CHANGED("kit-editor.editor-location-changed"),
    KIT_EDITOR_CANNOT_FIND_EDITOR_LOCATION("kit-editor.cannot-find-editor-location"),
    KIT_EDITOR_EDITING("kit-editor.editing"),
    KIT_NOT_EXISTS("kit.not-exists"),
    KIT_NO_KITS_FOUND("kit.no-kits-found"),
    KIT_SAVED_ALL_KITS("kit.saved-all-kits"),
    KIT_KIT_ALREADY_EXISTS("kit.kit-already-exists"),
    KIT_SUCCESSFULLY_CREATE("kit.successfully-create"),
    KIT_SUCCESSFULLY_DELETE("kit.successfully-delete"),
    KIT_CANNOT_SAVE_EXTRA_ITEMS("kit.cannot-save-extra-items"),
    KIT_SUCCESSFULLY_UPDATED_EXTRA_ITEMS("kit.successfully-updated-extra-items"),
    KIT_BUTTON_EDIT_DAMAGE_TICKS_NAME("kit.button.edit-damage-ticks.name"),
    KIT_BUTTON_EDIT_DAMAGE_TICKS_LORE("kit.button.edit-damage-ticks.lore"),
    KIT_BUTTON_EDIT_DAMAGE_TICKS_PROCEDURE_MESSAGE("kit.button.edit-damage-ticks.procedure.message"),
    KIT_BUTTON_EDIT_DAMAGE_TICKS_PROCEDURE_SUCCESS("kit.button.edit-damage-ticks.procedure.success"),
    KIT_BUTTON_EDIT_DAMAGE_TICKS_PROCEDURE_ADDITIONAL_MESSAGE("kit.button.edit-damage-ticks.procedure.additional-message"),
    KIT_BUTTON_EDIT_DESCRIPTION_NAME("kit.button.edit-description.name"),
    KIT_BUTTON_EDIT_DESCRIPTION_LORE_START("kit.button.edit-description.lore-start"),
    KIT_BUTTON_EDIT_DESCRIPTION_LORE_END("kit.button.edit-description.lore-end"),
    KIT_BUTTON_EDIT_DESCRIPTION_PROCEDURE_MESSAGE("kit.button.edit-description.procedure.message"),
    KIT_BUTTON_EDIT_DESCRIPTION_PROCEDURE_SUCCESS("kit.button.edit-description.procedure.success"),
    KIT_BUTTON_EDIT_DESCRIPTION_PROCEDURE_ADDITIONAL_MESSAGE("kit.button.edit-description.procedure.additional-message"),
    KIT_BUTTON_EDIT_DISPLAY_NAME_NAME("kit.button.edit-display-name.name"),
    KIT_BUTTON_EDIT_DISPLAY_NAME_LORE("kit.button.edit-display-name.lore"),
    KIT_BUTTON_EDIT_DISPLAY_NAME_PROCEDURE_MESSAGE("kit.button.edit-display-name.procedure.message"),
    KIT_BUTTON_EDIT_DISPLAY_NAME_PROCEDURE_SUCCESS("kit.button.edit-display-name.procedure.success"),
    KIT_BUTTON_EDIT_EXTRA_ITEMS_NAME("kit.button.edit-extra-items.name"),
    KIT_BUTTON_EDIT_EXTRA_ITEMS_LORE("kit.button.edit-extra-items.lore"),
    KIT_BUTTON_EDIT_ICON_NAME("kit.button.edit-icon.name"),
    KIT_BUTTON_EDIT_ICON_LORE("kit.button.edit-icon.lore"),
    KIT_BUTTON_EDIT_ICON_PROCEDURE_MESSAGE("kit.button.edit-icon.procedure.message"),
    KIT_BUTTON_EDIT_ICON_PROCEDURE_SUCCESS("kit.button.edit-icon.procedure.success"),
    KIT_BUTTON_EDIT_ICON_PROCEDURE_ADDITIONAL_MESSAGE("kit.button.edit-icon.procedure.additional-message"),
    KIT_BUTTON_EDIT_MATCH_TYPE_NAME("kit.button.edit-match-type.name"),
    KIT_BUTTON_EDIT_MATCH_TYPE_LORE_CLICK_LEFT("kit.button.edit-match-type.lore-click-left"),
    KIT_BUTTON_EDIT_MATCH_TYPE_LORE_CLICK_MIDDLE("kit.button.edit-match-type.lore-click-middle"),
    KIT_BUTTON_EDIT_MATCH_TYPE_LORE_CLICK_RIGHT("kit.button.edit-match-type.lore-click-right"),
    KIT_BUTTON_EDIT_MATCH_TYPE_LORE("kit.button.edit-match-type.lore"),
    KIT_BUTTON_EDIT_POTION_EFFECT_NAME("kit.button.edit-potion-effect.name"),
    KIT_BUTTON_EDIT_POTION_EFFECT_LORE_START("kit.button.edit-potion-effect.lore-start"),
    KIT_BUTTON_EDIT_POTION_EFFECT_LORE_END("kit.button.edit-potion-effect.lore-end"),
    KIT_BUTTON_EDIT_POTION_EFFECT_PROCEDURE_MESSAGE("kit.button.edit-potion-effect.procedure.message"),
    KIT_BUTTON_EDIT_POTION_EFFECT_PROCEDURE_ALREADY_HAVE_POTION_EFFECT("kit.button.edit-potion-effect.procedure.already-have-potion-effect"),
    KIT_BUTTON_EDIT_POTION_EFFECT_PROCEDURE_SUCCESS_ADD("kit.button.edit-potion-effect.procedure.success-add"),
    KIT_BUTTON_EDIT_POTION_EFFECT_PROCEDURE_SUCCESS_REMOVE("kit.button.edit-potion-effect.procedure.success-remove"),
    KIT_BUTTON_EDIT_POTION_EFFECT_PROCEDURE_ADDITIONAL_MESSAGE("kit.button.edit-potion-effect.procedure.additional-message"),
    KIT_BUTTON_EDIT_PRIORITY_NAME("kit.button.edit-priority.name"),
    KIT_BUTTON_EDIT_PRIORITY_LORE("kit.button.edit-priority.lore"),
    KIT_BUTTON_EDIT_PRIORITY_PROCEDURE_MESSAGE("kit.button.edit-priority.procedure.message"),
    KIT_BUTTON_EDIT_PRIORITY_PROCEDURE_SUCCESS("kit.button.edit-priority.procedure.success"),
    KIT_BUTTON_EDIT_PRIORITY_PROCEDURE_ADDITIONAL_MESSAGE("kit.button.edit-priority.procedure.additional-message"),
    KIT_BUTTON_PREVIEW_LORE("kit.button.preview.lore"),
    KIT_BUTTON_RULES_TOGGLE_SUCCESS("kit.button.rules-toggle.success"),
    KIT_BUTTON_SAVE_LOADOUT_NAME("kit.button.save-loadout.name"),
    KIT_BUTTON_SAVE_LOADOUT_LORE("kit.button.save-loadout.lore"),
    KIT_BUTTON_SAVE_LOADOUT_SUCCESS("kit.button.save-loadout.success"),
    KIT_BUTTON_TOGGLE_NAME("kit.button.toggle.name"),
    KIT_BUTTON_TOGGLE_LORE("kit.button.toggle.description"),
    KIT_BUTTON_TOGGLE_SUCCESS("kit.button.toggle.success"),
    KIT_BUTTON_TOGGLE_RANKED_NAME("kit.button.toggle-ranked.name"),
    KIT_BUTTON_TOGGLE_RANKED_LORE("kit.button.toggle-ranked.description"),
    KIT_BUTTON_TOGGLE_RANKED_SUCCESS("kit.button.toggle-ranked.success"),
    KIT_KIT_DETAIL_MENU_TITLE("kit.kit-detail-menu.title"),
    KIT_KIT_PREVIEW_MENU_TITLE("kit.kit-preview-menu.title"),
    KIT_KIT_MANAGEMENT_MENU_TITLE("kit.kit-management-menu.title"),
    KIT_KIT_MANAGEMENT_MENU_BUTTON_NAME("kit.kit-management-menu.button.name"),
    KIT_KIT_MANAGEMENT_MENU_BUTTON_LORE("kit.kit-management-menu.button.lore"),

    KIT_GAME_RULES_RECEIVE_KIT_LOADOUT_BOOK_RULES("kit.game-rules.receive-kit-loadout-book.rules"),
    KIT_GAME_RULES_RECEIVE_KIT_LOADOUT_BOOK_DESCRIPTION("kit.game-rules.receive-kit-loadout-book.description"),
    KIT_GAME_RULES_DEATH_ON_WATER_RULES("kit.game-rules.death-on-water.rules"),
    KIT_GAME_RULES_DEATH_ON_WATER_DESCRIPTION("kit.game-rules.death-on-water.description"),
    KIT_GAME_RULES_BOXING_RULES("kit.game-rules.boxing.rules"),
    KIT_GAME_RULES_BOXING_DESCRIPTION("kit.game-rules.boxing.description"),
    KIT_GAME_RULES_BED_RULES("kit.game-rules.bed.rules"),
    KIT_GAME_RULES_BED_DESCRIPTION("kit.game-rules.bed.description"),
    KIT_GAME_RULES_BRIDGE_RULES("kit.game-rules.bridge.rules"),
    KIT_GAME_RULES_BRIDGE_DESCRIPTION("kit.game-rules.bridge.description"),
    KIT_GAME_RULES_PROJECTILE_ONLY_RULES("kit.game-rules.projectile-only.rules"),
    KIT_GAME_RULES_PROJECTILE_ONLY_DESCRIPTION("kit.game-rules.projectile-only.description"),
    KIT_GAME_RULES_HYPIXELUHC_RULES("kit.game-rules.hypixelUHC.rules"),
    KIT_GAME_RULES_HYPIXELUHC_DESCRIPTION("kit.game-rules.hypixelUHC.description"),
    KIT_GAME_RULES_SPLEEF_RULES("kit.game-rules.spleef.rules"),
    KIT_GAME_RULES_SPLEEF_DESCRIPTION("kit.game-rules.spleef.description"),
    KIT_GAME_RULES_HEALTH_REGENERATION_RULES("kit.game-rules.health-regeneration.rules"),
    KIT_GAME_RULES_HEALTH_REGENERATION_DESCRIPTION("kit.game-rules.health-regeneration.description"),
    KIT_GAME_RULES_SHOW_HEALTH_RULES("kit.game-rules.show-health.rules"),
    KIT_GAME_RULES_SHOW_HEALTH_DESCRIPTION("kit.game-rules.show-health.description"),
    KIT_GAME_RULES_FOOD_LEVEL_CHANGE_RULES("kit.game-rules.food-level-change.rules"),
    KIT_GAME_RULES_FOOD_LEVEL_CHANGE_DESCRIPTION("kit.game-rules.food-level-change.description"),
    KIT_GAME_RULES_POINT_RULES("kit.game-rules.point.rules"),
    KIT_GAME_RULES_POINT_DESCRIPTION("kit.game-rules.point.description"),
    KIT_GAME_RULES_BUILD_RULES("kit.game-rules.build.rules"),
    KIT_GAME_RULES_BUILD_DESCRIPTION("kit.game-rules.build.description"),
    KIT_GAME_RULES_START_FREEZE_RULES("kit.game-rules.start-freeze.rules"),
    KIT_GAME_RULES_START_FREEZE_DESCRIPTION("kit.game-rules.start-freeze.description"),
    KIT_GAME_RULES_NO_DAMAGE_RULES("kit.game-rules.no-damage.rules"),
    KIT_GAME_RULES_NO_DAMAGE_DESCRIPTION("kit.game-rules.no-damage.description"),
    KIT_GAME_RULES_INSTANT_GAPPLE_RULES("kit.game-rules.instant-gapple.rules"),
    KIT_GAME_RULES_INSTANT_GAPPLE_DESCRIPTION("kit.game-rules.instant-gapple.description"),
    KIT_GAME_RULES_ENDER_PEARL_COOLDOWN_RULES("kit.game-rules.ender-pearl-cooldown.rules"),
    KIT_GAME_RULES_ENDER_PEARL_COOLDOWN_DESCRIPTION("kit.game-rules.ender-pearl-cooldown.description"),
    KIT_GAME_RULES_CLEAR_BLOCK_RULES("kit.game-rules.clear-block.rules"),
    KIT_GAME_RULES_CLEAR_BLOCK_DESCRIPTION("kit.game-rules.clear-block.description"),
    KIT_GAME_RULES_DROP_ITEM_WHEN_DIE_RULES("kit.game-rules.drop-item-when-die.rules"),
    KIT_GAME_RULES_DROP_ITEM_WHEN_DIE_DESCRIPTION("kit.game-rules.drop-item-when-die.description"),
    KIT_GAME_RULES_NO_FALL_DAMAGE_RULES("kit.game-rules.no-fall-damage.rules"),
    KIT_GAME_RULES_NO_FALL_DAMAGE_DESCRIPTION("kit.game-rules.no-fall-damage.description"),
    LEADERBOARD_RELOAD("leaderboard.reload"),
    LEADERBOARD_TOP10_DISPLAY_NAME("leaderboard.top10-display.name"),
    LEADERBOARD_TOP10_DISPLAY_LORE("leaderboard.top10-display.lore"),
    LEADERBOARD_BEST_WINSTREAK_MENU_TITLE("leaderboard.best-winstreak-menu-title"),
    LEADERBOARD_ELO_MENU_TITLE("leaderboard.elo-menu-title"),
    LEADERBOARD_WINS_MENU_TITLE("leaderboard.wins-menu-title"),
    LEADERBOARD_WINSTREAK_MENU_TITLE("leaderboard.wins-menu-title"),
    LEADERBOARD_KIT_STATS_MENU_TITLE("leaderboard.kit-stats-menu.title"),
    LEADERBOARD_KIT_STATS_MENU_GLOBAL_STATS_NAME("leaderboard.kit-stats-menu.global-stats.name"),
    LEADERBOARD_KIT_STATS_MENU_GLOBAL_STATS_LORE("leaderboard.kit-stats-menu.global-stats.lore"),
    LEADERBOARD_KIT_STATS_MENU_KIT_STATS_NAME("leaderboard.kit-stats-menu.kit-stats.name"),
    LEADERBOARD_KIT_STATS_MENU_KIT_STATS_LORE("leaderboard.kit-stats-menu.kit-stats.lore"),
    LEADERBOARD_ERROR_NOT_ENOUGH_SLOT("leaderboard.error-not-enough-slot"),
    LEADERBOARD_SWITCH_LEADERBOARD_BUTTON_VIEW_STATS_BUTTON_NAME("leaderboard.switch-leaderboard-button.view-stats-button.name"),
    LEADERBOARD_SWITCH_LEADERBOARD_BUTTON_VIEW_STATS_BUTTON_LORE("leaderboard.switch-leaderboard-button.view-stats-button.lore"),
    LOBBY_CHANGED_SPAWN_LOCATION("lobby.changed-spawn-location"),
    MATCH_SEPARATE("match.separate"),
    MATCH_START_UNRANKED("match.start-unranked"),
    MATCH_START_RANKED("match.start-ranked"),
    MATCH_JOIN_SPECTATE("match.join-spectate"),
    MATCH_LEAVE_SPECTATE("match.leave-spectate"),
    MATCH_CANNOT_DROP_WEAPON("match.cannot-drop-weapon"),
    MATCH_USE_AGAIN_GOLDEN_HEAD("match.use-again-golden-head"),
    MATCH_USE_AGAIN_ENDER_PEARL("match.use-again-ender-pearl"),
    MATCH_RECEIVED_KIT_LOADOUT("match.received-kit-loadout"),
    MATCH_RECEIVED_KIT_LOADOUT_BECAUSE_TIMEOUT("match.received-kit-loadout-because-timeout"),
    MATCH_CANNOT_BUILD_OUTSIDE("match.cannot-build-outside"),
    MATCH_CANNOT_BREAK_OWN_BED("match.cannot-break-own-bed"),
    MATCH_BED_BREAK_TITLE("match.bed-break.title"),
    MATCH_BED_BREAK_SUBTITLE("match.bed-break.subtitle"),
    MATCH_BED_BREAK_MESSAGE("match.bed-break.message"),
    MATCH_DEATH_MESSAGE_DISCONNECT("match.death-message.disconnect"),
    MATCH_DEATH_MESSAGE_KILLED("match.death-message.killed"),
    MATCH_DEATH_MESSAGE_DEFAULT("match.death-message.default"),
    MATCH_POST_MATCH_INVENTORY_WINNER("match.post-match-inventory.winner"),
    MATCH_POST_MATCH_INVENTORY_LOSER("match.post-match-inventory.loser"),
    MATCH_POST_MATCH_INVENTORY_HOVER("match.post-match-inventory.hover"),
    MATCH_POST_MATCH_INVENTORY_MESSAGE("match.post-match-inventory.message"),
    MATCH_POST_MATCH_INVENTORY_RATING_CHANGES("match.post-match-inventory.rating-changes"),
    MATCH_SPECTATE_WRONG_STATE("match.spectate.wrong-state"),
    MATCH_SPECTATE_HAVE_PARTY("match.spectate.have-party"),
    MATCH_SPECTATE_NOT_ONLINE("match.spectate.not-online"),
    MATCH_SPECTATE_PROFILE_NOT_FOUND("match.spectate.profile-not-found"),
    MATCH_VIEW_INVENTORY_WRONG_STATE("match.view-inventory.wrong-state"),
    MATCH_VIEW_INVENTORY_USAGE("match.view-inventory.usage"),
    MATCH_VIEW_INVENTORY_INVALID_UUID("match.view-inventory.invalid-uuid"),
    MATCH_VIEW_INVENTORY_CANNOT_FIND("match.view-inventory.cannot-find"),
    MATCH_SPECTATE_MENU_TITLE("match.spectate-menu.title"),
    MATCH_SPECTATE_MENU_BUTTON_NAME_SOLO("match.spectate-menu.button.name-solo"),
    MATCH_SPECTATE_MENU_BUTTON_NAME_SPLIT("match.spectate-menu.button.name-split"),
    MATCH_SPECTATE_MENU_BUTTON_NAME_FFA("match.spectate-menu.button.name-ffa"),
    MATCH_SPECTATE_MENU_BUTTON_NAME_ERROR("match.spectate-menu.button.name-error"),
    MATCH_SPECTATE_MENU_BUTTON_LORE("match.spectate-menu.button.lore"),
    MATCH_SPECTATE_MENU_ERROR_BUTTON_NAME("match.spectate-menu.error-button.name"),
    MATCH_SPECTATE_MENU_ERROR_BUTTON_LORE("match.spectate-menu.error-button.lore"),
    MATCH_SPECTATE_TELEPORT_MENU_TITLE("match.spectate-teleport-menu.title"),
    MATCH_SPECTATE_TELEPORT_MENU_BUTTON_NAME("match.spectate-teleport-menu.button.name"),
    MATCH_SPECTATE_TELEPORT_MENU_BUTTON_LORE("match.spectate-teleport-menu.button.lore"),
    MATCH_SPECTATE_TELEPORT_MENU_WRONG_STATE("match.spectate-teleport-menu.wrong-state"),
    MATCH_SPECTATE_TELEPORT_MENU_ALREADY_DIED("match.spectate-teleport-menu.already-died"),
    MATCH_SPECTATE_TELEPORT_MENU_NOT_ONLINE("match.spectate-teleport-menu.not-online"),
    MATCH_SPECTATE_TELEPORT_MENU_TARGET_WRONG_STATE("match.spectate-teleport-menu.target-wrong-state"),
    MATCH_SPECTATE_TELEPORT_MENU_NOT_SAME_MATCH("match.spectate-teleport-menu.not-same-match"),
    MATCH_VIEW_INVENTORY_MENU_TITLE("match.view-inventory-menu.title"),
    MATCH_VIEW_INVENTORY_MENU_OPEN_MESSAGE("match.view-inventory-menu.open-message"),
    MATCH_VIEW_INVENTORY_MENU_SWITCH_INVENTORY_BUTTON_NAME("match.view-inventory-menu.switch-inventory-button.name"),
    MATCH_VIEW_INVENTORY_MENU_PLAYER_INFORMATION_BUTTON_NAME("match.view-inventory-menu.player-information-button.name"),
    MATCH_VIEW_INVENTORY_MENU_PLAYER_INFORMATION_BUTTON_LORE("match.view-inventory-menu.player-information-button.lore"),
    MATCH_VIEW_INVENTORY_MENU_EFFECTS_BUTTON_NAME("match.view-inventory-menu.player-information-button.name"),
    MATCH_VIEW_INVENTORY_MENU_EFFECTS_BUTTON_NO_EFFECTS_LORE("match.view-inventory-menu.player-information-button.no-effects-lore"),
    MATCH_VIEW_INVENTORY_MENU_EFFECTS_BUTTON_EFFECTS_FORMAT("match.view-inventory-menu.player-information-button.effects-format"),
    MATCH_VIEW_INVENTORY_MENU_HEALING_BUTTON_NAME("match.view-inventory-menu.healing-button.name"),
    MATCH_VIEW_INVENTORY_MENU_HEALING_BUTTON_NO_HEALING_LORE("match.view-inventory-menu.healing-button.no-healing-lore"),
    MATCH_VIEW_INVENTORY_MENU_HEALING_BUTTON_HEALING_LORE("match.view-inventory-menu.healing-button.healing-lore"),
    MATCH_VIEW_INVENTORY_MENU_STATISTICS_BUTTON_NAME("match.view-inventory-menu.statistics-button.name"),
    MATCH_VIEW_INVENTORY_MENU_STATISTICS_BUTTON_LORE("match.view-inventory-menu.statistics-button.lore"),
    MATCH_HEALING_METHOD_POTION("match.healing-method.potion"),
    MATCH_HEALING_METHOD_SOUP("match.healing-method.soup"),
    MATCH_HEALING_METHOD_GOLDEN_APPLE("match.healing-method.golden-apple"),
    MATCH_NEW_ROUND_START_MESSAGE("match.new-round-start.message"),
    MATCH_NEW_ROUND_START_TITLE("match.new-round-start.title"),
    MATCH_NEW_ROUND_START_SCORE("match.new-round-start.score"),
    MATCH_RESPAWN_MESSAGE("match.respawn.message"),
    MATCH_TEAM_COLOR_RED_NAME("match.team-color.red.name"),
    MATCH_TEAM_COLOR_RED_LOGO("match.team-color.red.logo"),
    MATCH_TEAM_COLOR_BLUE_NAME("match.team-color.blue.name"),
    MATCH_TEAM_COLOR_BLUE_LOGO("match.team-color.blue.logo"),
    MATCH_TEAM_COLOR_GREEN_NAME("match.team-color.green.name"),
    MATCH_TEAM_COLOR_GREEN_LOGO("match.team-color.green.logo"),
    MATCH_TEAM_COLOR_YELLOW_NAME("match.team-color.yellow.name"),
    MATCH_TEAM_COLOR_YELLOW_LOGO("match.team-color.yellow.logo"),
    MATCH_TEAM_COLOR_AQUA_NAME("match.team-color.aqua.name"),
    MATCH_TEAM_COLOR_AQUA_LOGO("match.team-color.aqua.logo"),
    MATCH_TEAM_COLOR_WHITE_NAME("match.team-color.white.name"),
    MATCH_TEAM_COLOR_WHITE_LOGO("match.team-color.white.logo"),
    MATCH_TEAM_COLOR_PINK_NAME("match.team-color.pink.name"),
    MATCH_TEAM_COLOR_PINK_LOGO("match.team-color.pink.logo"),
    MATCH_TEAM_COLOR_GRAY_NAME("match.team-color.gray.name"),
    MATCH_TEAM_COLOR_GRAY_LOGO("match.team-color.gray.logo"),
    MATCH_MATCH_TYPE_SOLO("match.match-type.solo"),
    MATCH_MATCH_TYPE_FFA("match.match-type.ffa"),
    MATCH_MATCH_TYPE_SPLIT("match.match-type.split"),
    PARTY_CREATED("party.created"),
    PARTY_SUCCESSFULLY_SET_MAX_SIZE("party.successfully-set-max-size"),
    PARTY_SUCCESSFULLY_SET_CHAT("party.successfully-set-chat"),
    PARTY_ANNOUNCE_MESSAGE("party.announce.message"),
    PARTY_ANNOUNCE_CLICKABLE("party.announce.clickable"),
    PARTY_ANNOUNCE_HOVER("party.announce.hover"),
    PARTY_PRIVACY_MESSAGE("party.privacy.message"),
    PARTY_PRIVACY_OPEN("party.privacy.open"),
    PARTY_PRIVACY_CLOSED("party.privacy.closed"),
    PARTY_BROADCAST_FORMAT("party.broadcast-format"),
    PARTY_OWN_PROFILE_NOT_FOUND("party.own-profile-not-found"),
    PARTY_JOIN_MESSAGE_NORMAL("party.join-message.normal"),
    PARTY_JOIN_MESSAGE_FORCE("party.join-message.force"),
    PARTY_LEAVE_MESSAGE_NORMAL("party.leave-message.normal"),
    PARTY_LEAVE_MESSAGE_FORCE("party.leave-message.force"),
    PARTY_DISBAND("party.disband"),
    PARTY_INVITE_TEAM_MESSAGE("party.invite.team-message"),
    PARTY_INVITE_INVITE_MESSAGE("party.invite.invite-message"),
    PARTY_INVITE_CLICKABLE("party.invite.clickable"),
    PARTY_INVITE_HOVER("party.invite.hover"),
    PARTY_INFORMATION("party.information"),
    PARTY_CHAT_OFF("party.chat-off"),
    PARTY_DISBAND_LEADER_LEFT("party.disband-leader-left"),
    PARTY_QUIT("party.quit"),
    PARTY_ONLY_LEADER("party.only-leader"),
    PARTY_IN_A_PARTY("party.in-a-party"),
    PARTY_NOT_IN_A_PARTY("party.not-in-a-party"),
    PARTY_WRONG_STATE("party.wrong-state"),
    PARTY_PARTY_NOT_OPEN("party.party-not-open"),
    PARTY_PLAYER_NOT_FOUND("party.player-not-found"),
    PARTY_PARTY_NOT_FOUND("party.party-not-found"),
    PARTY_FULL("party.full"),
    PARTY_ALREADY_IN_PARTY("party.already-in-party"),
    PARTY_NOT_INVITED("party.not-invited"),
    PARTY_DISABLED_PARTY_INVITE("party.disabled-party-invite"),
    PARTY_NOT_INTEGER("party.not-integer"),
    PARTY_SIZE_BELOW_1("party.size-below-1"),
    PARTY_ERROR_LEADER_NOT_FOUND("party.error-leader-not-found"),
    PARTY_MAX_SIZE("party.max-size"),
    PARTY_HELP_MESSAGE("party.help-message"),
    PARTY_CHOOSE_ARENA_MENU_TITLE("party.choose-arena-menu.title"),
    PARTY_CHOOSE_ARENA_MENU_BUTTON_NAME("party.choose-arena-menu.button.name"),
    PARTY_CHOOSE_ARENA_MENU_BUTTON_LORE("party.choose-arena-menu.button.lore"),
    PARTY_CHOOSE_KIT_MENU_TITLE("party.choose-kit-menu.title"),
    PARTY_CHOOSE_KIT_MENU_BUTTON_NAME("party.choose-kit-menu.button.name"),
    PARTY_CHOOSE_KIT_MENU_BUTTON_LORE("party.choose-kit-menu.button.lore"),
    PARTY_CHOOSE_MATCH_TYPE_MENU_TITLE("party.choose-match-type-menu.title"),
    PARTY_CHOOSE_MATCH_TYPE_MENU_SPLIT_BUTTON_NAME("party.choose-match-type-menu.split-button.name"),
    PARTY_CHOOSE_MATCH_TYPE_MENU_SPLIT_BUTTON_LORE("party.choose-match-type-menu.split-button.lore"),
    PARTY_CHOOSE_MATCH_TYPE_MENU_FFA_BUTTON_NAME("party.choose-match-type-menu.ffa-button.name"),
    PARTY_CHOOSE_MATCH_TYPE_MENU_FFA_BUTTON_LORE("party.choose-match-type-menu.ffa-button.lore"),
    PARTY_OTHER_PARTIES_MENU_TITLE("party.other-parties-menu.title"),
    PARTY_OTHER_PARTIES_MENU_BUTTON_NAME("party.other-parties-menu.button.name"),
    PARTY_OTHER_PARTIES_MENU_BUTTON_LORE_START("party.other-parties-menu.button.lore-start"),
    PARTY_OTHER_PARTIES_MENU_BUTTON_LORE_END("party.other-parties-menu.button.lore-end"),
    PARTY_START_PARTY_FIGHT_ONLY_LEADER("party.start-party-fight.only-leader"),
    PARTY_START_PARTY_FIGHT_NEED_MORE_THAN_2("party.start-party-fight.need-more-than-2"),
    PARTY_START_PARTY_FIGHT_CANNOT_FIND_ARENA("party.start-party-fight.cannot-find-arena"),
    PARTY_START_PARTY_FIGHT_PLAYERS_NOT_IN_LOBBY("party.start-party-fight.players-not-in-lobby"),
    PROFILE_CANNOT_FIND_PLAYER("profile.cannot-find-player"),
    PROFILE_ERROR_CANNOT_LOAD_PLAYER("profile.error-cannot-load-player"),
    PROFILE_KIT_RIGHT_CLICK_TO_RECEIVE("profile.kit-right-click-to-receive"),
    PROFILE_SETTINGS_MENU_TITLE("profile.settings-menu.title"),
    PROFILE_SETTINGS_MENU_CLICK_TO_SWITCH_SETTINGS("profile.settings-menu.click-to-switch-settings"),
    PROFILE_SETTINGS_MENU_NO_PERMISSION("profile.settings-menu.no-permission"),
    PROFILE_PROCEDURE_ENTER_CANCEL_TO_CANCEL("profile.procedure.enter-cancel-to-cancel"),
    PROFILE_PROCEDURE_SUCCESS_CANCEL("profile.procedure.success-cancel"),
    PROFILE_SETTINGS_TIME_CHANGER_NAME("profile.settings.time-changer.name"),
    PROFILE_SETTINGS_TIME_CHANGER_LORE("profile.settings.time-changer.lore"),
    PROFILE_SETTINGS_TIME_CHANGER_NORMAL_SERVER_TIME("profile.settings.time-changer.normal-server-time"),
    PROFILE_SETTINGS_TIME_CHANGER_DAY("profile.settings.time-changer.day"),
    PROFILE_SETTINGS_TIME_CHANGER_AFTERNOON("profile.settings.time-changer.afternoon"),
    PROFILE_SETTINGS_TIME_CHANGER_NIGHT("profile.settings.time-changer.night"),
    PROFILE_SETTINGS_TIME_CHANGER_MIDNIGHT("profile.settings.time-changer.midnight"),
    PROFILE_SETTINGS_ARENA_SELECTION_NAME("profile.settings.arena-selection.name"),
    PROFILE_SETTINGS_ARENA_SELECTION_LORE("profile.settings.arena-selection.lore"),
    PROFILE_SETTINGS_MATCH_SCOREBOARD_NAME("profile.settings.match-scoreboard.name"),
    PROFILE_SETTINGS_MATCH_SCOREBOARD_LORE("profile.settings.match-scoreboard.lore"),
    PROFILE_SETTINGS_ALLOW_DUEL_REQUEST_NAME("profile.settings.allow-duel-request.name"),
    PROFILE_SETTINGS_ALLOW_DUEL_REQUEST_LORE("profile.settings.allow-duel-request.lore"),
    PROFILE_SETTINGS_ALLOW_PARTY_INVITE_NAME("profile.settings.allow-party-invite.name"),
    PROFILE_SETTINGS_ALLOW_PARTY_INVITE_LORE("profile.settings.allow-party-invite.lore"),
    PROFILE_SETTINGS_SPECTATOR_VISIBILITY_NAME("profile.settings.spectator-visibility.name"),
    PROFILE_SETTINGS_SPECTATOR_VISIBILITY_LORE("profile.settings.spectator-visibility.lore"),
    PROFILE_SETTINGS_PING_RANGE_NAME("profile.settings.ping-range.name"),
    PROFILE_SETTINGS_PING_RANGE_LORE("profile.settings.ping-range.lore"),
    PROFILE_SETTINGS_PING_RANGE_UNLIMITED("profile.settings.ping-range.unlimited"),
    QUEUE_USAGE("queue.usage"),
    QUEUE_CANNOT_QUIT_QUEUE("queue.cannot-quit-queue"),
    QUEUE_CANNOT_QUEUE("queue.cannot-queue"),
    QUEUE_TYPE_UNRANKED("queue.type.unranked"),
    QUEUE_TYPE_RANKED("queue.type.ranked"),
    QUEUE_MENU_TITLE("queue.menu.title"),
    QUEUE_MENU_BUTTON_LORE("queue.menu.button.lore"),
    QUEUE_ERROR_FOUND_QUEUE_PROFILE("queue.error-found-queue-profile"),
    QUEUE_ERROR_NOT_FOUND_QUEUE_PROFILE("queue.error-not-found-queue-profile"),
    QUEUE_WRONG_STATE("queue.wrong-state"),
    QUEUE_ERROR_KIT_DATA_NOT_FOUND("queue.error-kit-data-not-found"),
    QUEUE_SUCCESS_JOIN("queue.success-join"),
    QUEUE_SUCCESS_QUIT("queue.success-quit"),
    BUTTON_BACK_NAME("button.back.name"),
    BUTTON_BACK_LORE("button.back.lore"),
    BUTTON_CONFIRM_NAME_CONFIRM("button.confirm.name-confirm"),
    BUTTON_CONFIRM_NAME_CANCEL("button.confirm.name-cancel"),
    BUTTON_JUMP_TO_PAGE_NAME("button.jump-to-page.name"),
    BUTTON_JUMP_TO_PAGE_CURRENT_PAGE_LORE("button.jump-to-page.current-page-lore"),
    BUTTON_PAGE_NEXT_PAGE_AVAILABLE_NAME("button.page.next-page-available.name"),
    BUTTON_PAGE_NEXT_PAGE_AVAILABLE_LORE("button.page.next-page-available.lore"),
    BUTTON_PAGE_NEXT_PAGE_CURRENT_NAME("button.page.next-page-current.name"),
    BUTTON_PAGE_NEXT_PAGE_CURRENT_LORE("button.page.next-page-current.lore"),
    BUTTON_PAGE_PREVIOUS_PAGE_AVAILABLE_NAME("button.page.previous-page-available.name"),
    BUTTON_PAGE_PREVIOUS_PAGE_AVAILABLE_LORE("button.page.previous-page-available.lore"),
    BUTTON_PAGE_PREVIOUS_PAGE_CURRENT_NAME("button.page.previous-page-current.name"),
    BUTTON_PAGE_PREVIOUS_PAGE_CURRENT_LORE("button.page.previous-page-current.lore"),
    BUTTON_PAGE_FILTER_NAME("button.page-filter.name"),
    BUTTON_PAGE_FILTER_LORE("button.page-filter.lore"),
    BUTTON_PAGE_FILTER_NO_FILTERS("button.page-filter.no-filters"),
    MENU_VIEW_ALL_PAGES_TITLE("menu.view-all-pages.title"),
    ;

    private final String path;

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(Object... replacements) {
        return toString(null, replacements);
    }

    public String toString(Player player, Object... replacements) {
        if (Util.isNull(Eden.INSTANCE.getLanguageFile().getString(path))) {
            return path;
        }
        String str = CC.translate(Eden.INSTANCE.getLanguageFile().getString(path));
        for (int i = 0; i < replacements.length; i++) {
            String replacement = convert(replacements[i]);
            str = str.replace("{" + i + "}", replacement);
        }
        if (player != null) {
            str = Eden.INSTANCE.getPlaceholder().translateScoreboard(player, str);
            if (Checker.isPlaceholderAPIEnabled()) {
                str = PlaceholderAPI.setPlaceholders(player, str);
            }
        }
        return str;
    }

    public List<String> toStringList(Object... replacements) {
        return toStringList(null, replacements);
    }

    public List<String> toStringList(Player player, Object... replacements) {
        if (Util.isNull(Eden.INSTANCE.getLanguageFile().getString(path))) {
            return Collections.singletonList(path);
        }
        List<String> strings = Eden.INSTANCE.getLanguageFile().getStringList(path).stream().map(str -> {
            for (int i = 0; i < replacements.length; i++) {
                String replacement = convert(replacements[i]);
                str = str.replace("{" + i + "}", replacement);
            }
            if (player != null) {
                str = Eden.INSTANCE.getPlaceholder().translateScoreboard(player, str);
                if (Checker.isPlaceholderAPIEnabled()) {
                    str = PlaceholderAPI.setPlaceholders(player, str);
                }
            }
            return str;
        }).collect(Collectors.toList());
        return CC.translate(strings);
    }

    public void sendMessage(Player player, Object... replacements) {
        Common.sendMessage(player, toString(player, replacements));
    }

    public void sendListOfMessage(Player player, Object... replacements) {
        Common.sendMessage(player, toStringList(player, replacements));
    }

    private String convert(Object object) {
        if (object instanceof Integer) {
            return object + "";
        } else if (object instanceof Double) {
            return object + "";
        } else if (object instanceof Long) {
            return object + "";
        } else if (object instanceof Short) {
            return object + "";
        } else if (object instanceof ChatColor) {
            return object.toString();
        } else {
            return (String) object;
        }
    }
}
