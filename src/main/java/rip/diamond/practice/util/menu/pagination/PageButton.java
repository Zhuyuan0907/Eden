package rip.diamond.practice.util.menu.pagination;

import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import rip.diamond.practice.Language;
import rip.diamond.practice.util.ItemBuilder;
import rip.diamond.practice.util.menu.Button;

@AllArgsConstructor
public class PageButton extends Button {

	private int mod;
	private PaginatedMenu menu;

	@Override
	public ItemStack getButtonItem(Player player) {
		if (this.mod > 0) {
			if (hasNext(player)) {
				return new ItemBuilder(Material.STAINED_GLASS_PANE)
						.durability(5)
						.name(Language.BUTTON_PAGE_NEXT_PAGE_AVAILABLE_NAME.toString())
						.lore(Language.BUTTON_PAGE_NEXT_PAGE_AVAILABLE_LORE.toStringList())
						.build();
			} else {
				return new ItemBuilder(Material.STAINED_GLASS_PANE)
						.durability(14)
						.name(Language.BUTTON_PAGE_NEXT_PAGE_CURRENT_NAME.toString())
						.lore(Language.BUTTON_PAGE_NEXT_PAGE_CURRENT_LORE.toStringList())
						.build();
			}
		} else {
			if (hasPrevious(player)) {
				return new ItemBuilder(Material.STAINED_GLASS_PANE)
						.durability(5)
						.name(Language.BUTTON_PAGE_PREVIOUS_PAGE_AVAILABLE_NAME.toString())
						.lore(Language.BUTTON_PAGE_PREVIOUS_PAGE_AVAILABLE_LORE.toStringList())
						.build();
			} else {
				return new ItemBuilder(Material.STAINED_GLASS_PANE)
						.durability(14)
						.name(Language.BUTTON_PAGE_PREVIOUS_PAGE_CURRENT_NAME.toString())
						.lore(Language.BUTTON_PAGE_PREVIOUS_PAGE_CURRENT_LORE.toStringList())
						.build();
			}
		}
	}

	@Override
	public void clicked(Player player, ClickType clickType) {
		if (this.mod > 0) {
			if (hasNext(player)) {
				this.menu.modPage(player, this.mod);
				Button.playNeutral(player);
			} else {
				Button.playFail(player);
			}
		} else {
			if (hasPrevious(player)) {
				this.menu.modPage(player, this.mod);
				Button.playNeutral(player);
			} else {
				Button.playFail(player);
			}
		}
	}

	private boolean hasNext(Player player) {
		int pg = this.menu.getPage() + this.mod;
		return this.menu.getPages(player) >= pg;
	}

	private boolean hasPrevious(Player player) {
		int pg = this.menu.getPage() + this.mod;
		return pg > 0;
	}

}
