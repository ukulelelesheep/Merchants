package com.gmail.sharpcastle33.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.gmail.sharpcastle33.markets.MarketMerchant;

public class TypingInName implements Listener {

	@EventHandler
	public void onPlayerChat (AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();		


		
		if (MarketMerchant.isPlayerTypingName.get(player) == true) {
			String message = event.getMessage();
			if (message.length() < 15) {
				MarketMerchant merchant = MarketMerchant.merchantPlayerIsRenaming.get(player);
				merchant.setName(message);
				player.sendMessage("This merchant's new name is " + message);
				MarketMerchant.isPlayerTypingName.put(player, false);
				event.setCancelled(true);
			} else {
				event.setCancelled(true);
				player.sendMessage("Message is too long, try again");
			}
		}
		
	}
	
}
