package com.gmail.sharpcastle33.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.PlayerInventory;

import com.gmail.sharpcastle33.markets.MarketMerchant;

public class CreateVillager implements Listener {
	
	@EventHandler
	public void chestClick(PlayerInteractEvent event) {
		
		//get block get player get inventory
		Block b = event.getClickedBlock();
		PlayerInventory inv = event.getPlayer().getInventory();
		Player player = event.getPlayer();
		
		//Set this item to key needed to change the chest
		Material specialItem = Material.STICK;
				
		if (inv.contains(specialItem)) {
			if (b.getState() instanceof Chest) {				
				MarketMerchant.createVillager(b, player);
				
				//Cancel inventory from opening
				event.setCancelled(true);
								
			} else {
				return;
			}
			
		} else {
			return;
		}
	}
	
}
