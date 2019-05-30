package com.gmail.sharpcastle33.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Test implements CommandExecutor{
	//private final Merchants plugin;
	
	/*public Test(Merchants plugin) {
		this.plugin = plugin;
		//this.plugin.getServer().getPluginManager().regi
	}
	*/
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		/*if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}			
		//Player player = (Player) sender; */
		

		//BukkitTask task = new MobAI(this.plugin, 5).runTaskTimer(this.plugin, 10, 20);
		
		
		//createVillager(player);
		

		
		return true;
	
	}
	
	/*public static void createVillager(Player player) {

		
		Location l = player.getLocation();
		
		Entity villager = player.getWorld().spawnEntity(l, EntityType.VILLAGER);
		
		
		ItemStack item0 = new ItemStack(Material.IRON_INGOT, 3);
		ItemStack item1 = new ItemStack(Material.DIAMOND, 3);
		ItemStack item2 = new ItemStack(Material.DIAMOND_SWORD, 1);
		
		//List<MerchantRecipe> recipe = new ArrayList<MerchantRecipe>();
		
		MerchantRecipe recipe = new MerchantRecipe(item2, 1, 1000, false);
		
		recipe.addIngredient(item0);
		recipe.addIngredient(item1);
		
		Merchant m = (Merchant) villager;
		int number = m.getRecipeCount();
		
		m.setRecipe(0, recipe);
		
		player.sendMessage("This villager has " + number + " trades");
		player.sendMessage("The first trade is" + m.getRecipe(0));
		
		
	}*/
	
}
