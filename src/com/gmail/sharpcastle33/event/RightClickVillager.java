package com.gmail.sharpcastle33.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

import com.gmail.sharpcastle33.markets.MarketMerchant;

public class RightClickVillager implements Listener{
	
	@EventHandler
	public void onVillagerClick(PlayerInteractEntityEvent event) {
	
		Entity e = event.getRightClicked();
		
		if (!(e instanceof Villager))
			return;
		
		if (!(event.getPlayer() instanceof Player)) 
			return;
		
		if (event.getHand() != EquipmentSlot.HAND)
			return;
		
		Player player = (Player) event.getPlayer();
		
		
		if (MarketMerchant.LUT.get(e) != null) {
			MarketMerchant mm = MarketMerchant.LUT.get(e);
			mm.openMainGUI(player, e);
			
		}
		
	}

}
