package com.gmail.sharpcastle33.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TypingInName implements Listener {

	@EventHandler
	public void onPlayerChat (AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();		
		String message = event.getMessage();
		
	}
	
}
