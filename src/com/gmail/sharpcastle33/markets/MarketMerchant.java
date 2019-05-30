package com.gmail.sharpcastle33.markets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

public class MarketMerchant {
	private Entity villager;
	private LivingEntity le;
	private Merchant m;
	private List<MerchantRecipe> recipes;
	
	public MarketMerchant(Entity villager, List<MerchantRecipe> recipes) {
		this.villager = villager;
		this.le = (LivingEntity) villager;
		this.setRecipes(recipes);
	}
	
	public Entity getVillager() {
		return villager;
	}
	
	public void setVillager(Entity villager) {
		if (villager.getType() == EntityType.VILLAGER) {
			this.villager = villager;
			this.le = (LivingEntity) villager;
			this.m = (Merchant) villager;
		}
	}
	
	public LivingEntity getLivingEntity() {
		return le;
	}

	public Merchant getMerchant() {
		return m;
	}
	
	public List<MerchantRecipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<MerchantRecipe> recipes) {
		this.recipes = recipes;
	}	
	
	public static void createVillager(Block b, Player player) {

		Chest chest = (Chest) b.getState();
		Location l = chest.getLocation();
		Entity villager = b.getWorld().spawnEntity(l, EntityType.VILLAGER);
		List<MerchantRecipe> recipes = new ArrayList<>();				
		ItemStack[] chestInv = chest.getInventory().getContents();
		//MarketStall marketStall = new MarketStall(l, player);
		
		//for each column in the chest
		for (int i = 0; i<=8; i++) {
			
			//if neither the first and third row are empty
			if (!(chestInv[i] == null || chestInv[i+18] == null)) {
				int price = chestInv[i+18].getAmount();
				int tradeStock = price + 0;
				int tradeQuantity = tradeStock/price;
				MerchantRecipe recipe = new MerchantRecipe(chestInv[i+18], 0, tradeQuantity, false);
				recipe.addIngredient(chestInv[i]);
				recipes.add(recipe);
				
				//if the second row is not empty, add a second ingredient
				if ((chestInv[i+9] != null)) {
					recipe.addIngredient(chestInv[i+9]);
				}
			}				
		} 
		MarketMerchant merchant = new MarketMerchant(villager, recipes);
		//Give the recipes to the Villager that spawns
		merchant.getMerchant().setRecipes(recipes);		
		//Turn the villager AI off
		merchant.getLivingEntity().setAI(false);
		merchant.getLivingEntity().setInvulnerable(true);
		
		//Delete the chest
		chest.getInventory().clear();
		b.setType(Material.AIR);

		//return marketStall;
		
	}
	
}
