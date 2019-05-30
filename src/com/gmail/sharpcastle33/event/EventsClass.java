package com.gmail.sharpcastle33.event;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitTask;

import com.gmail.sharpcastle33.Merchants;
import com.gmail.sharpcastle33.MobAI;


public class EventsClass implements Listener {
	
	private final Merchants plugin;
	
	public EventsClass(Merchants plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void blockplace(BlockPlaceEvent event) {
		if (event.getBlock().getType() == Material.WEB) {
			BukkitTask task = new MobAI(this.plugin, 5).runTaskTimer(this.plugin, 10, 20);
			task.cancel();
		}

	}
}