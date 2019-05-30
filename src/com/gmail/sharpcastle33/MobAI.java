package com.gmail.sharpcastle33;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MobAI extends BukkitRunnable{
	
	
	
	private final JavaPlugin plugin;
	private int counter;
	
	public MobAI (JavaPlugin plugin, int counter) {
		this.plugin = plugin;
		if (counter < 1) {
			throw new IllegalArgumentException("counter must be greater than 1");
		} else {
			this.counter = counter;
		}
	}
	
	@Override
	public void run() {
		if (counter > 0) {
			plugin.getServer().broadcastMessage("Commence greeting in " + counter--);
		} else {
			plugin.getServer().broadcastMessage("Welcome to Bukkit! Remember to read the documentation");
			this.cancel();
		}
	}

}
