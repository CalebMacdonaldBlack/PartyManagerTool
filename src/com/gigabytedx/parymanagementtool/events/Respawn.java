package com.gigabytedx.parymanagementtool.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.gigabytedx.Main;
import com.gigabytedx.parymanagementtool.commands.GetPartyTool;

public class Respawn implements Listener {

	Main plugin;

	public Respawn(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onRepsawn(PlayerRespawnEvent event){
		GetPartyTool.giveTool(event.getPlayer());
	}
}
