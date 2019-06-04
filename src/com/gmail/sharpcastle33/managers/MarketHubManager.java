package com.gmail.sharpcastle33.managers;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import com.gmail.sharpcastle33.markets.MarketHub;

public class MarketHubManager {
	//List of all the market hubs	
	public ArrayList<MarketHub> markets = new ArrayList<MarketHub>();
	private static HashMap<Player, MarketHub> defaultMarket = new HashMap<Player, MarketHub>();
	
	
	//Create markets
	public MarketHub createMarket(Player player, Block block) {
		MarketHub m = new MarketHub(player, block);
		markets.add(m);
		setDefaultMarket(player, m);
		player.sendMessage("Market Created");
		player.sendMessage("Click on plots with a stick to add them to the market");
		block.setType(Material.JACK_O_LANTERN);
		return m;
	}

	//Remove markets
	public void removeMarket(MarketHub m) {
		markets.remove(m);
	}
	
	public void setDefaultMarket(Player p, MarketHub m) {
		defaultMarket.put(p, m);
	}
	
	public MarketHub getDefaultMarket(Player p) {
		return defaultMarket.get(p);
	}
	
	public boolean hasDefaultMarket(Player p) {
		return defaultMarket.containsKey(p);
	}
	
	
}