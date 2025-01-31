package rip.diamond.practice.kits.menu.button.impl;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import rip.diamond.practice.Language;
import rip.diamond.practice.kits.Kit;
import rip.diamond.practice.kits.menu.KitPreviewMenu;
import rip.diamond.practice.kits.menu.button.KitButton;
import rip.diamond.practice.util.ItemBuilder;
import rip.diamond.practice.util.menu.Menu;

public class KitPreviewButton extends KitButton {

    private final Menu backMenu;

    public KitPreviewButton(Kit kit, Menu backMenu) {
        super(kit);
        this.backMenu = backMenu;
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(getKit().getDisplayIcon())
                .name(getKit().getDisplayName())
                .lore(Language.KIT_BUTTON_PREVIEW_LORE.toStringList())
                .build();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarSlot) {
        if (clickType == ClickType.LEFT) {
            new KitPreviewMenu(getKit(), backMenu).openMenu(player);
        } else if (clickType == ClickType.RIGHT) {
            player.getInventory().setContents(getKit().getKitLoadout().getContents());
            player.getInventory().setArmorContents(getKit().getKitLoadout().getArmor());
            player.updateInventory();
            player.closeInventory();
        }
    }
}
