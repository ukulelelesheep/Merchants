package com.gmail.sharpcastle33;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.sharpcastle33.commands.Test;
import com.gmail.sharpcastle33.event.ClickEnchantingTable;
import com.gmail.sharpcastle33.event.ClickMarket;
import com.gmail.sharpcastle33.event.ClickStall;
import com.gmail.sharpcastle33.event.EventsClass;
import com.gmail.sharpcastle33.event.MarketListClick;
import com.gmail.sharpcastle33.event.MerchantMainClick;
import com.gmail.sharpcastle33.event.ProfessionsInventoryClick;
import com.gmail.sharpcastle33.event.RightClickVillager;
import com.gmail.sharpcastle33.event.TypingInName;
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
		pm.registerEvents(new ClickMarket(), this);
		pm.registerEvents(new ClickStall(), this);
		pm.registerEvents(new ClickEnchantingTable(), this);
		pm.registerEvents(new ProfessionsInventoryClick(), this);
		pm.registerEvents(new RightClickVillager(), this);
		pm.registerEvents(new MerchantMainClick(), this);
		pm.registerEvents(new TypingInName(), this);
		pm.registerEvents(new MarketListClick(), this);
	}
	
	
}
