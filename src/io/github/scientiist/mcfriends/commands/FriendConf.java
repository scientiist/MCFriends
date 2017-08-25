package io.github.scientiist.mcfriends.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import io.github.scientiist.mcfriends.YamlFileIO;

public class FriendConf implements CommandExecutor {
	

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		
		
		String command = cmd.getName().toLowerCase();
		if (command.equals("friendconf")) {
			
			
			if (!(sender instanceof Player)) {
				return true;
			}
			
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage(ChatColor.BLUE+"MCFriends configuration: /friendconf <action> [arguments]");
				player.sendMessage(ChatColor.WHITE+"Actions: allowteleport");
				return true;
				
			} else {
				
				if (args[0].equalsIgnoreCase("allowteleport")) {
						YamlConfiguration config = YamlFileIO.getPlayerConfig(player);
						if (args.length == 2) {
							if (args[1].equalsIgnoreCase("true")) {
								player.sendMessage(ChatColor.BLUE+"allowteleport"+ChatColor.GRAY+" set to true.");
								config.set("config.allowfriendteleport", true);
								YamlFileIO.setPlayer(player, config);
								return true;
								
							}
							
							if (args[1].equalsIgnoreCase("false")) {
								player.sendMessage(ChatColor.BLUE+"allowteleport"+ChatColor.GRAY+" set to false.");
								config.set("config.allowfriendteleport", false);
								YamlFileIO.setPlayer(player, config);
								return true;
							}
						}
						
						
						player.sendMessage(ChatColor.BLUE+"allowteleport: "+config.getBoolean("config.allowfriendteleport")+ChatColor.GRAY+" || VALID: true, false");
						return true;
						
					
				}
				
			}
			return true;
		}
		return false;
	}

}
