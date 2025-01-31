package rip.diamond.practice.kits.menu.button.impl;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import rip.diamond.practice.Language;
import rip.diamond.practice.kits.Kit;
import rip.diamond.practice.kits.KitMatchType;
import rip.diamond.practice.kits.menu.button.KitButton;
import rip.diamond.practice.util.CC;
import rip.diamond.practice.util.ItemBuilder;
import rip.diamond.practice.util.menu.Menu;

public class KitEditMatchTypeButton extends KitButton {

    private final Menu menu;

    public KitEditMatchTypeButton(Kit kit, Menu menu) {
        super(kit);
        this.menu = menu;
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.FLINT)
                .name(Language.KIT_BUTTON_EDIT_MATCH_TYPE_NAME.toString())
                .lore(
                        "",
                        (getKit().getKitMatchTypes().contains(KitMatchType.SOLO) ? CC.GREEN + " » " : CC.GRAY + "   ") + "Solo " + Language.KIT_BUTTON_EDIT_MATCH_TYPE_LORE_CLICK_LEFT.toString(),
                        (getKit().getKitMatchTypes().contains(KitMatchType.FFA) ? CC.GREEN + " » " : CC.GRAY + "   ") + "FFA " + Language.KIT_BUTTON_EDIT_MATCH_TYPE_LORE_CLICK_MIDDLE.toString(),
                        (getKit().getKitMatchTypes().contains(KitMatchType.SPLIT) ? CC.GREEN + " » " : CC.GRAY + "   ") + "Split " + Language.KIT_BUTTON_EDIT_MATCH_TYPE_LORE_CLICK_RIGHT.toString()
                )
                .lore(Language.KIT_BUTTON_EDIT_MATCH_TYPE_LORE.toStringList())
                .build();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarSlot) {
        playNeutral(player);
        switch (clickType) {
            case LEFT:
                if (getKit().getKitMatchTypes().contains(KitMatchType.SOLO)) {
                    getKit().getKitMatchTypes().remove(KitMatchType.SOLO);
                } else {
                    getKit().getKitMatchTypes().add(KitMatchType.SOLO);
                }
                break;
            case MIDDLE:
                if (getKit().getKitMatchTypes().contains(KitMatchType.FFA)) {
                    getKit().getKitMatchTypes().remove(KitMatchType.FFA);
                } else {
                    getKit().getKitMatchTypes().add(KitMatchType.FFA);
                }
                break;
            case RIGHT:
                if (getKit().getKitMatchTypes().contains(KitMatchType.SPLIT)) {
                    getKit().getKitMatchTypes().remove(KitMatchType.SPLIT);
                } else {
                    getKit().getKitMatchTypes().add(KitMatchType.SPLIT);
                }
                break;
            default:
                break;
        }
        menu.openMenu(player);
    }
}
