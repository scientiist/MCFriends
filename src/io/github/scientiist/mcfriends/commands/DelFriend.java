package io.github.scientiist.mcfriends.commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import io.github.scientiist.mcfriends.MCFriends;
import io.github.scientiist.mcfriends.YamlFileIO;

public class DelFriend  implements CommandExecutor {
	

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		
		
		String command = cmd.getName().toLowerCase();
		if (command.equals("delfriend")) {
			if (!(args.length == 1)) { return false; }
			
			if (!(sender instanceof Player)) { 
				sender.sendMessage(ChatColor.RED+"ERROR: Only players should use this command.");
				return true;
			}
			
			Player player = (Player) sender;
			
			Player targetFriend = MCFriends.pl.getServer().getPlayer(args[0]);
			
			if (targetFriend == null) {
				player.sendMessage(ChatColor.RED+"ERROR: Player not found.");
				return true;
			}
			
			YamlConfiguration config = YamlFileIO.getPlayerConfig(player);
			
			List<String> l = config.getStringList("friends");
				
			String friendUUID = targetFriend.getUniqueId().toString();
				
			if (!l.contains(friendUUID)) {
				player.sendMessage(ChatColor.RED+"ERROR: Player is not on your friends list.");
				return true;
			}
			
			l.remove(friendUUID);
			config.set("friends", l);
			YamlFileIO.setPlayer(player, config);
			player.sendMessage(ChatColor.GRAY+"You have removed "+ChatColor.WHITE+targetFriend.getDisplayName()+ChatColor.GRAY+" as a friend.");
			targetFriend.sendMessage(player.getDisplayName()+ChatColor.GRAY+" has removed you as a friend.");
			return true;
		}
		return false;
	}
}
