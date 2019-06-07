package com.gmail.sharpcastle33.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.sharpcastle33.markets.MarketMerchant;


public class ProfessionsInventoryClick implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		
		if(!(inv.getTitle().equals("What profession do you need?"))) 
			return;
		
		if(!(event.getWhoClicked() instanceof Player)) 
			return;
		
		if(event.isShiftClick()) {
			event.setCancelled(true);
		}
		
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		if(item.getType() == Material.ITEM_FRAME) {
			MarketMerchant merchant = MarketMerchant.createVillager(player);
			player.sendMessage("<" + merchant.getName() + "> Hello, I can be your merchant");
		}
		
		event.setCancelled(true);
		
		if(!(event.isShiftClick())) {
			player.closeInventory();
		}
	}
}
