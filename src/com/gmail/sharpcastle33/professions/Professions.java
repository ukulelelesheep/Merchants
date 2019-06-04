package com.gmail.sharpcastle33.professions;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Professions {
	public static final String[] professions = {"Merchant"};
	public static final Material[] professionIcons = {Material.ITEM_FRAME};

	
	
	public static void openProfessionsInventory(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, "What profession do you need?");
		for (int i = 0; i < professions.length; i++) {
			inv.setItem(i, nameItem(professionIcons[i], professions[i]));
		}		
		
		player.openInventory(inv);		
	}
	
	private static ItemStack nameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);		
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack nameItem(Material item, String name) {
		return nameItem(new ItemStack(item), name);
	}
	
}
