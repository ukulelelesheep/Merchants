package com.gmail.sharpcastle33.managers;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.gmail.sharpcastle33.markets.MarketHub;
import com.gmail.sharpcastle33.markets.MarketMerchant;

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
	
	//Inventory of all the markets
	public void showMarkets(MarketMerchant mm, Player player) {		
		int numberOfColumns = (((markets.size() - (markets.size()%9)))/9)+1;
		
		Inventory marketHubIcons = Bukkit.createInventory((InventoryHolder) mm.getVillager(), numberOfColumns*9, "Where should I go?");

		int i = 0;
		for (MarketHub hub : markets) {
			Material m = hub.getStallMaterial();
			if (m != null) {
				ItemStack icon = new ItemStack(m);
				MarketMerchant.nameItem(icon, hub.getName());
				marketHubIcons.setItem(i, icon);
			} else {
				ItemStack icon = new ItemStack(Material.JACK_O_LANTERN);
				MarketMerchant.nameItem(icon, hub.getName());
				marketHubIcons.setItem(i, icon);
			}
			
			i++;

		}
		
		player.openInventory(marketHubIcons);
	
	}
	
}