package com.gmail.sharpcastle33.markets;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class MarketHub {
	private ArrayList<MarketStall> marketStalls = new ArrayList<MarketStall>();
	private Player owner;
	private Block block;
	private Material stallMaterial;
	private String name;
	private static int marketNumber;
	
	public MarketHub(Player owner, Block block) {
		this.owner = owner;
		this.block = block;
		this.name = "Market " + marketNumber++;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public Block getBlock() {
		return block;
	}
	
	public void setBlock(Block block) {
		this.block = block;
	}
	
	public ArrayList<MarketStall> getMarketStalls() {
		return marketStalls;
	}
	
	public void addMarketStall(MarketStall s) {
		this.marketStalls.add(s);
	}
	
	public void removeMarketStall(MarketStall s) {
		this.marketStalls.remove(s);
	}
	
	public Material getStallMaterial() {
		return stallMaterial;
	}
	
	public void setStallMaterial(Material m) {
		this.stallMaterial = m;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String s) {
		this.name = s;
	}


	
}
