package com.gigabytedx;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gigabytedx.parymanagementtool.commands.GetPartyTool;
import com.gigabytedx.parymanagementtool.events.Interact;
import com.gigabytedx.parymanagementtool.events.Join;
import com.gigabytedx.parymanagementtool.events.Respawn;

public class Main extends JavaPlugin{
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		registerEvents();
		registerCommands();
		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");
	}

	private void registerCommands() {
		getCommand("getpartytool").setExecutor(new GetPartyTool(this));
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Interact(this), this);
		pm.registerEvents(new Join(this), this);
		pm.registerEvents(new Respawn(this), this);
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdfFile.getName() + " has been disabled (V." + pdfFile.getVersion() + ")");
	}
}
