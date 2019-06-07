package com.gmail.sharpcastle33.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.sharpcastle33.Merchants;
import com.gmail.sharpcastle33.markets.MarketHub;
import com.gmail.sharpcastle33.markets.MarketMerchant;

public class MarketListClick implements Listener {

	@EventHandler
	public void onMarketClick(InventoryClickEvent event) {
		
		Inventory inventory = event.getInventory();
		
		if(!(inventory.getTitle().equals("Where should I go?"))) 
			return;
		
		if(event.isShiftClick()) {
			event.setCancelled(true);
		}
		
		ItemStack item = event.getCurrentItem();
		
		Entity villager = (Villager) inventory.getHolder();
		
		Player player = (Player) event.getWhoClicked();
		
		MarketMerchant merchant = MarketMerchant.LUT.get(villager);
		
		for (MarketHub hub : Merchants.hubManager.markets) {
			if (hub.getName() == item.getItemMeta().getDisplayName()) {
				merchant.sendVillager(merchant, hub);
				
				player.closeInventory();
			}
		}
		
		event.setCancelled(true);

		
	}
	
}
