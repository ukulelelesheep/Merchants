package com.gmail.sharpcastle33.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import com.gmail.sharpcastle33.professions.Professions;

public class ClickEnchantingTable implements Listener{
	
	@EventHandler
	public void ClickTable(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Block b = e.getClickedBlock();
		if(b != null && b.getType() == Material.ENCHANTMENT_TABLE) {		
			if (e.getHand() == EquipmentSlot.HAND) {
				Professions.openProfessionsInventory(player);
				e.setCancelled(true);
			}			
		}
	}
	
}
