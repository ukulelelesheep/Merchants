package com.gmail.sharpcastle33.markets;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import com.gmail.sharpcastle33.Merchants;

public class MarketMerchant {
	private Entity villager;
	private LivingEntity le;
	private Merchant m;
	private Player owner;
	private ArrayList<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>();
	//private ItemStack[] tradesInventory = new ItemStack[36];
	private MarketHub marketHub;
	private Inventory trades = Bukkit.createInventory(null, 27, "Set Trade");
	private Inventory inventory = Bukkit.createInventory(null, 27, "Current Stock");
	public static HashMap<Entity, MarketMerchant> LUT = new HashMap<>();
	private String name;
	private static int villagerNumber = 1;
	
	public static HashMap<Player, Boolean> isPlayerTypingName = new HashMap<>();
	public static HashMap<Player, MarketMerchant> merchantPlayerIsRenaming = new HashMap<>();
	
	public static ArrayList<String> names = new ArrayList<>();
	
	public MarketMerchant(Entity villager, Player owner) {
		this.villager = villager;
		this.le = (LivingEntity) villager;
		this.m = (Merchant) villager;
		this.owner = owner;
		this.name = "Merchant #" + villagerNumber++;
		names.add(this.name);
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
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
	public static MarketMerchant createVillager(Player player) {

		Location l = player.getLocation();
		Entity villager = player.getWorld().spawnEntity(l, EntityType.VILLAGER);

		MarketMerchant merchant = new MarketMerchant(villager, player);
		
		//Turn the villager AI off
		merchant.getLivingEntity().setAI(false);
		merchant.getLivingEntity().setInvulnerable(true);
		
		merchant.setRecipes(merchant.recipes);
		
		LUT.put(villager, merchant);
		
		return merchant;
	}
	
	
	
	
	public void openMainGUI(Player player, Entity villager) {
		
		/*if (player != mm.getOwner())
			return;
		*/
		MarketMerchant merchant = LUT.get(villager);
		//open inventory
		Inventory inv = Bukkit.createInventory((InventoryHolder) villager, 9, merchant.getName());
		ItemStack recipeItem = new ItemStack(Material.EMERALD);		
		recipeItem = nameItem(recipeItem, "Set Trades");
		inv.setItem(0, recipeItem);
		
		ItemStack stockItem = new ItemStack(Material.CHEST);		
		stockItem = nameItem(stockItem, "Add to Trade Supply");
		inv.setItem(1, stockItem);
		
		ItemStack renameItem = new ItemStack(Material.NAME_TAG);
		renameItem = nameItem(renameItem, "Rename");
		inv.setItem(2, renameItem);
		
		
		ItemStack marketListItem = new ItemStack(Material.FEATHER);
		marketListItem = nameItem(marketListItem, "Send to a market");
		inv.setItem(3, marketListItem);
		
		player.openInventory(inv);
		
		//if set recipes tab has been clicked, open recipe click GUI
		
		//if rename button has been pushed open rename GUI
		
		//if stock button is pushed open Stock GUI
		
		//if send button is pushed, open market list GUI
				
	}
	
	public static ItemStack nameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);		
		item.setItemMeta(meta);
		return item;
	}
	
	public void openRecipeGUI(MarketMerchant mm, Player player) {
		

		player.openInventory(mm.trades);
		
		//In slots 1-9 put items "Trade x First Trade Item (click to see options)". Don't consume item
		
		//In slots 10-18 put items "Trade x Second Trade Item (option)". Don't consume item
		
		//In slots 19-27 put items "Trade x Sell Item". Consume item and add to stock
		
	}
	
	public void openStockGUI(MarketMerchant mm, Player player) {
		
		//Create 9*3 GUI
		player.openInventory(mm.inventory);
		
		//Show all the items being sold along with how many there are. Items are default in the order they are in the recipe GUI
		//Maximum capacity 27 stacks
		
		//What if there are more than one trade of a certain item. 
		
	}
	
	public void openRenameGUI(MarketMerchant merchant, Player player) {
		player.sendMessage("Please type in this villagers new name");
		isPlayerTypingName.put(player, true);
		merchantPlayerIsRenaming.put(player, merchant);

	}
	
	public void openMarketListGUI(Player player) {
		
		Merchants.hubManager.showMarkets(this, player);
		
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
				int tradeQuantity = (tradeStock - (tradeStock % price)) / price;
				MerchantRecipe recipe = new MerchantRecipe(inv[i+18], 0, tradeQuantity, false);
				recipe.addIngredient(inv[i]);

				
				//if the second row is not empty, add a second ingredient
				if ((inv[i+9] != null)) {
					recipe.addIngredient(inv[i+9]);
				}
				recipes.add(recipe);
			}			
		} 
		
	}
	

	
	public boolean sendVillager(MarketMerchant mm, MarketHub hub) {		
		for (MarketStall stall : hub.getMarketStalls()) {			
			if (stall.getMarketMerchant() == null) {
				stall.setMarketMerchant(mm);
				Vector vec = new Vector(.5f, 1f, .5f);
				mm.getVillager().teleport(stall.getLocation().add(vec));
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		names.add(name);
	}




	
}
