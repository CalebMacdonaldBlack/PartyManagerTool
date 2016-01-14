package com.gigabytedx.parymanagementtool.events;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import com.gigabytedx.Main;

public class Interact implements Listener {
	HashMap<String, Boolean> playerParyAddToggle = new HashMap<String, Boolean>();
	Main plugin;

	public Interact(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInteract(PlayerInteractAtEntityEvent event) {
		try{
		if (event.getPlayer().getItemInHand().getItemMeta().getDisplayName()
				.equals(ChatColor.GOLD + "Pary Management Tool") && event.getRightClicked() instanceof Player) {
			
			if (playerParyAddToggle.containsKey(event.getRightClicked().getName())) {
				if (playerParyAddToggle.get(event.getRightClicked().getName())) {
					
					addPlayer(event.getPlayer(), (Player) event.getRightClicked());
				} else {
					
					removePlayer(event.getPlayer(), (Player) event.getRightClicked());
				}
			} else {
				
				addPlayer(event.getPlayer(), (Player) event.getRightClicked());
			}
		}
		}catch(NullPointerException e){
			
		}
	}

	public void addPlayer(Player player, Player clickedPlayer) {
		if(playerParyAddToggle.containsKey(player.getName())){
			playerParyAddToggle.remove(player.getName());
		}
		Bukkit.dispatchCommand(clickedPlayer, "pdisband");
		Bukkit.dispatchCommand(player, "pcreate " + player.getName());
		Bukkit.dispatchCommand(player, "pinvite " + clickedPlayer.getName());
		Bukkit.dispatchCommand(clickedPlayer, "pdisband");
		Bukkit.dispatchCommand(clickedPlayer, "pjoin " + player.getName());
		playerParyAddToggle.put(clickedPlayer.getName(), false);
	}

	public void removePlayer(Player player, Player clickedPlayer) {
		Bukkit.dispatchCommand(player, "pkick " + clickedPlayer.getName());
		playerParyAddToggle.put(clickedPlayer.getName(), true);
	}
}
