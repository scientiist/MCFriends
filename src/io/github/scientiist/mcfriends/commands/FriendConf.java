package io.github.scientiist.mcfriends.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.scientiist.mcfriends.YamlFileIO;

public class FriendConf implements CommandExecutor {
	

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		
		
		String command = cmd.getName().toLowerCase();
		if (command.equals("friendconf")) {
			
			
			if (!(sender instanceof Player)) {
				
				return false;
			}
			
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage(ChatColor.BLUE+"MCFriends configuration: /friendconf <action> [arguments]");
				player.sendMessage(ChatColor.WHITE+"Actions: allowteleport");
				return true;
			} else {
				
				if (args[0].equalsIgnoreCase("allowteleport")) {
						boolean allowTP;
						if (args[1].equalsIgnoreCase("true")) {
							allowTP = true;
							
						}
						
						if (args[1].equalsIgnoreCase("false")) {
							allowTP = false;
						}
						
						YamlFileIO.getPlayerConfig(player);
						
						
						player.sendMessage("");
					
					return true;
				}
				
			}
		}
		return false;
	}

}
