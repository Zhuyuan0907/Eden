package rip.diamond.practice.kits.menu.button.impl;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import rip.diamond.practice.Language;
import rip.diamond.practice.kits.Kit;
import rip.diamond.practice.kits.menu.KitDetailsMenu;
import rip.diamond.practice.kits.menu.button.KitButton;
import rip.diamond.practice.util.ItemBuilder;
import rip.diamond.practice.util.menu.menus.ConfirmMenu;

public class KitSaveLoadoutButton extends KitButton {

    private final Kit kit;

    public KitSaveLoadoutButton(Kit kit) {
        super(kit);

        this.kit = kit;
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.CHEST)
                .name(Language.KIT_BUTTON_SAVE_LOADOUT_NAME.toString())
                .lore(Language.KIT_BUTTON_SAVE_LOADOUT_LORE.toStringList())
                .build();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarSlot) {
        new ConfirmMenu((bool) -> {
            if (bool) {
                kit.getKitLoadout().setArmor(player.getInventory().getArmorContents());
                kit.getKitLoadout().setContents(player.getInventory().getContents());
                kit.save(true);
                Language.KIT_BUTTON_SAVE_LOADOUT_SUCCESS.sendMessage(player, kit.getName());
            }
            new KitDetailsMenu(getKit(), null).openMenu(player);
        }, true, null).openMenu(player);
    }
}
