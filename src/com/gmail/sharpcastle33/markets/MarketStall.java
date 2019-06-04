package com.gmail.sharpcastle33.markets;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.gmail.sharpcastle33.Merchants;

public class MarketStall {
	
	private Location location;
	private MarketMerchant merchant;
	private MarketHub hub = new MarketHub(null, null);
	private Player owner;
	
	public MarketStall(Location location, Player owner, MarketHub hub) {
		this.location = location;	
		this.owner = owner;
		this.hub = hub;
		this.merchant = null;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location l) {
		this.location = l;
	}
	
	public MarketMerchant getMarketMerchant() {
		return merchant;
	}
	
	public void setMarketMerchant(MarketMerchant mm) {
		this.merchant = mm;
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
