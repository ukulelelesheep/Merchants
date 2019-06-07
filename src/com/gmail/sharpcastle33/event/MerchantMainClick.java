package com.gmail.sharpcastle33.event;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.sharpcastle33.markets.MarketMerchant;

public class MerchantMainClick implements Listener {
	
	@EventHandler
	public void onMainGUIClick(InventoryClickEvent event) {
		
		Inventory inv = event.getInventory();
		
		boolean go = false;
		
		for (String name : MarketMerchant.names) {	
			if(inv.getTitle().equals(name)) {
				go = true;
			}
		}
		
		if (!go) {
			return;
		}
			
		if (!(event.getWhoClicked() instanceof Player)) 
			return;
		
		if(event.isShiftClick()) {
			event.setCancelled(true);
		}
		
		Entity villager = (Entity) inv.getHolder();

		MarketMerchant mm = MarketMerchant.LUT.get(villager);
		
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		if(item.getType() == Material.EMERALD) {
			mm.openRecipeGUI(mm, player);
			event.setCancelled(true);
		} if (item.getType() == Material.CHEST) {
			mm.openStockGUI(mm, player);
			event.setCancelled(true);
		} if (item.getType() == Material.NAME_TAG) {
			player.closeInventory();
			mm.openRenameGUI(mm, player);
		} if (item.getType() == Material.FEATHER) {
			player.closeInventory();
			mm.openMarketListGUI(player); 
		}
		
	}
	
}
