package com.gmail.sharpcastle33.markets;

import java.util.ArrayList;

import org.bukkit.Location;
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
	private Player owner;
	private ArrayList<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>();
	//private ItemStack[] tradesInventory = new ItemStack[36];
	private MarketHub marketHub;
	
	public MarketMerchant(Entity villager, ArrayList<MerchantRecipe> recipes, Player owner) {
		this.villager = villager;
		this.le = (LivingEntity) villager;
		this.m = (Merchant) villager;
		this.owner = owner;
		this.setRecipes(recipes);
		this.marketHub = null;
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
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public ArrayList<MerchantRecipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<MerchantRecipe> recipes) {
		this.recipes = recipes;
		this.m.setRecipes(recipes);
	}
	
	private MarketHub getMarketHub() {
		return marketHub;
	}
	
	private void setMarketHub(MarketHub hub) {
		this.marketHub = hub;
	}
	
	public static void createVillager(Player player) {

		Location l = player.getLocation();
		Entity villager = player.getWorld().spawnEntity(l, EntityType.VILLAGER);

		MarketMerchant merchant = new MarketMerchant(villager, null, player);
		
		//Turn the villager AI off
		merchant.getLivingEntity().setAI(false);
		merchant.getLivingEntity().setInvulnerable(true);
		
	}
	
	
	
	public void openMainGUI(MarketMerchant mm, Player player) {
		
		if (player != mm.getOwner())
			return;
		
		//open inventory
		
		//if set recipes tab has been clicked, open recipe click GUI
		
		//if rename button has been pushed open rename GUI
		
		//if stock button is pushed open Stock GUI
		
		//if send button is pushed, open market list GUI
				
	}
	
	public void openRecipeGUI(MarketMerchant mm, Player player) {
		
		//Create 9*3 GUI
		
		//In slots 1-9 put items "Trade x First Trade Item (click to see options)". Don't consume item
		
		//In slots 10-18 put items "Trade x Second Trade Item (option)". Don't consume item
		
		//In slots 19-27 put items "Trade x Sell Item". Consume item and add to stock
		
	}
	
	public void openStockGUI(MarketMerchant mm, Player player) {
		
		//Create 9*3 GUI
		
		//Show all the items being sold along with how many there are. Items are default in the order they are in the recipe GUI
		//Maximum capacity 27 stacks
		
		//What if there are more than one trade of a certain item. 
		
	}
	
	public void openRenameGUI(MarketMerchant mm, Player player) {
		
		//Create Anvil inventory
		
	}
	
	public void openMarketListGUI(MarketMerchant mm, Player player) {
		
		//Create GUI size rounding up market number up to the nearest multiple of 9
		
		//Show all markets
		
	}
	
	
	public void addRecipes(ItemStack[] inv) {
		
		if (inv == null) {
			return;
		}
		
		//for each column in the inventory
		for (int i = 0; i<=8; i++) {
			//if neither the first and third row are empty
			if (inv[i] != null && inv[i+18] != null) {
				int price = inv[i+18].getAmount();
				int tradeStock = price + 0;
				int tradeQuantity = tradeStock/price;
				MerchantRecipe recipe = new MerchantRecipe(inv[i+18], 0, tradeQuantity, false);
				recipe.addIngredient(inv[i]);
				recipes.add(recipe);
				
				//if the second row is not empty, add a second ingredient
				if ((inv[i+9] != null)) {
					recipe.addIngredient(inv[i+9]);
				}
			}			
		} 
		
	}
	

	
	public boolean sendVillager(MarketMerchant mm, MarketHub hub) {		
		for (MarketStall stall : hub.getMarketStalls()) {			
			if (stall.getMarketMerchant() == null) {
				stall.setMarketMerchant(mm);				
				mm.getVillager().teleport(stall.getLocation());
				mm.setMarketHub(hub);
				return true;
			}			
		}		
		return false;				
	}
	
	public void moveVillager(MarketMerchant mm, MarketStall stall) {
				
		if (stall.getMarketHub().equals(mm.getMarketHub())) {
			mm.getVillager().teleport(stall.getLocation());
			stall.setMarketMerchant(mm);
		}
		
	}



	
}
