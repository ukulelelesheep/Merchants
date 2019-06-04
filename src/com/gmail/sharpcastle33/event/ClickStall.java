package com.gmail.sharpcastle33.event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import com.gmail.sharpcastle33.Merchants;
import com.gmail.sharpcastle33.markets.MarketHub;
import com.gmail.sharpcastle33.markets.MarketStall;

public class ClickStall implements Listener {	
	
	@EventHandler
	public void plotClick(PlayerInteractEvent e) {

		Player player = e.getPlayer();
		if(e.getHand() == EquipmentSlot.HAND) {
		
			Material specialItem = Material.BLAZE_ROD;
			if (player.getInventory().getItemInMainHand().getType() == specialItem) {
				Block block = e.getClickedBlock();
				Location l = block.getLocation();
				
				if (Merchants.hubManager.hasDefaultMarket(player)) {
					MarketHub h = Merchants.hubManager.getDefaultMarket(player);
					
					if (h.getMarketStalls().isEmpty()) {
						h.setStallMaterial(block.getType());
						MarketStall stall = new MarketStall(l, player, h);
						h.addMarketStall(stall);
						player.sendMessage("The market stalls of this market are " + h.getStallMaterial().toString().toLowerCase() + " blocks. Click with a blaze rod to create more stalls");
					} else if (block.getType() == h.getStallMaterial()) {
						MarketStall stall = new MarketStall(l, player, h);
						h.addMarketStall(stall);
						player.sendMessage("You added a market stall");
					} else {
						player.sendMessage("Click on " + h.getStallMaterial().toString().toLowerCase() + " blocks instead");
					}
				} else {
					player.sendMessage("Create a market first");
				}
	
			}
		}
	}
}
