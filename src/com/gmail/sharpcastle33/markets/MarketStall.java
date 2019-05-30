package com.gmail.sharpcastle33.markets;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.MerchantRecipe;

import com.gmail.sharpcastle33.Merchants;

public class MarketStall {
	
	private Location location;
	private Entity villager;
	private List<MerchantRecipe> recipes;
	private MarketHub hub;
	private Player owner;
	
	public MarketStall(Location location, Player owner, MarketHub hub) {
		this.location = location;	
		this.owner = owner;
		this.hub = hub;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location l) {
		this.location = l;
	}
	
	public Entity getVillager() {
		return villager;
	}
	
	public void setVillager(Entity v) {
		this.villager = v;
	}
	
	public List<MerchantRecipe> getRecipes() {
		return recipes;
	}
	
	public void setRecipes(List<MerchantRecipe> r) {
		this.recipes = r;
	}
	
	public MarketHub getMarketHub() {
		return hub;
	}
	
	public void setHub(Player player) {
		this.hub = Merchants.hubManager.getDefaultMarket(player);
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
