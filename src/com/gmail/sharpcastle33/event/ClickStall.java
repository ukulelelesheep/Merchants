package com.gmail.sharpcastle33.event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.sharpcastle33.Merchants;
import com.gmail.sharpcastle33.markets.MarketHub;
import com.gmail.sharpcastle33.markets.MarketStall;

public class ClickStall implements Listener {	
	
	@EventHandler
	public void plotClick(PlayerInteractEvent e) {

		Player player = e.getPlayer();
		
		Material specialItem = Material.STICK;
		if (player.getInventory().contains(specialItem)) {
			Block block = e.getClickedBlock();
			Location l = block.getLocation();
			MarketHub h = Merchants.hubManager.getDefaultMarket(player);
			
			if (h.getMarketStalls().isEmpty()) {
				h.setStallMaterial(block.getType());
			} else if (block.getType() == h.getStallMaterial()) {
				MarketStall stall = new MarketStall(l, player, h);
				h.addMarketStall(stall);
			} else {
				player.sendMessage("Click on " + block.getType().toString() + " instead");
			}
		}
	}
}
