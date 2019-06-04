package com.gmail.sharpcastle33.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.sharpcastle33.Merchants;

public class ClickMarket implements Listener {
	
	
	@EventHandler
	public void pumpkinClick(PlayerInteractEvent e) {		
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
			if (b != null && b.getType() == Material.PUMPKIN) {			
				Merchants.hubManager.createMarket(p, b);			
			}		
	}
}