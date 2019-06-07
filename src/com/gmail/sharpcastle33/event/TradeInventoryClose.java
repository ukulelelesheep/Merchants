package com.gmail.sharpcastle33.event;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import com.gmail.sharpcastle33.markets.MarketMerchant;

public class TradeInventoryClose implements Listener {
	
	@EventHandler
	public void onTradeInventoryClose(InventoryCloseEvent event) {
		
		Inventory inventory = event.getInventory();
		
		if (!(inventory.getTitle().equals("Set Trade"))) return;
		
		Entity villager = (Entity) inventory.getHolder();
		MarketMerchant merchant = MarketMerchant.LUT.get(villager);
		
		merchant.addRecipes(inventory.getContents());
		
	}
	
	
}
