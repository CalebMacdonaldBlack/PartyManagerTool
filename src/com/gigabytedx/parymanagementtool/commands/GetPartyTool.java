package com.gigabytedx.parymanagementtool.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gigabytedx.Main;

public class GetPartyTool implements CommandExecutor {

	Main plugin;

	public GetPartyTool(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			giveTool((Player) sender);
		}
		return false;
	}

	public static void giveTool(Player player) {
		boolean needsStick = true;
		for (int itemSlot = 0; itemSlot < 40; itemSlot++) {
			try {
				if (player.getInventory().getItem(itemSlot).getItemMeta().getDisplayName()
						.equals(ChatColor.GOLD + "Pary Management Tool")) {
					needsStick = false;
				}
			} catch (NullPointerException e) {

			}
		}
		if (needsStick) {
			ItemStack is = new ItemStack(Material.STICK);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.GOLD + "Pary Management Tool");
			List<String> list = new ArrayList<>();
			list.add(ChatColor.BLUE + "Right click your friends to add");
			list.add(ChatColor.BLUE + "to your party for dungeons");
			im.setLore(list);
			is.setItemMeta(im);
			player.getInventory().addItem(is);
		}
	}

}
