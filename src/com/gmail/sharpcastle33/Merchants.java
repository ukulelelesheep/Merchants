package com.gmail.sharpcastle33;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.sharpcastle33.commands.Test;
import com.gmail.sharpcastle33.event.CreateVillager;
import com.gmail.sharpcastle33.event.EventsClass;
import com.gmail.sharpcastle33.managers.MarketHubManager;


public class Merchants extends JavaPlugin {
	
	public static MarketHubManager hubManager;
	
	public void onEnable() {
		loadConfig();
		registerCommands();
		registerEvents();
		new EventsClass(this);
		hubManager = new MarketHubManager();
	}
	

	public void onDisable() {
		
	}
	
	private void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		
	}
	
	private void registerCommands() {
		getCommand("test").setExecutor(new Test());
	}
	
	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();		
		pm.registerEvents(new CreateVillager(), this);
	}
	
	
}
