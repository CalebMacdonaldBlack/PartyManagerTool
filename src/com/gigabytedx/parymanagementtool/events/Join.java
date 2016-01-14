package com.gigabytedx.parymanagementtool.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gigabytedx.Main;
import com.gigabytedx.parymanagementtool.commands.GetPartyTool;

public class Join implements Listener {

	Main plugin;

	public Join(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		GetPartyTool.giveTool(event.getPlayer());
	}
}
