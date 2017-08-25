package io.github.scientiist.mcfriends.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import io.github.scientiist.mcfriends.MCFriends;
import io.github.scientiist.mcfriends.YamlFileIO;

public class ToFriend implements CommandExecutor {
	

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		
		if (cmd.getLabel().equalsIgnoreCase("tofriend")) {
			if (!(args.length == 1)) { return false; }
			
			if (!(sender instanceof Player)) {
				sender.sendMessage("ERROR: Only players should use this command.");
				return true;
			}
			
			Player player = (Player) sender;
			
			Player targetFriend = MCFriends.pl.getServer().getPlayer(args[0]);
			
			if (targetFriend == null) {
				player.sendMessage(ChatColor.RED+"ERROR: Player not found.");
				return true;
			}
			
			YamlConfiguration targetConf = YamlFileIO.getPlayerConfig(targetFriend);
			
			if (!targetConf.getStringList("friends").contains(player.getUniqueId().toString())) {
				player.sendMessage(ChatColor.RED+"ERROR: You are not on this player's friend list.");
				return true;
			}
			
			if (targetConf.getBoolean("config.allowfriendteleport") != true) {
				player.sendMessage(ChatColor.RED+"ERROR: Player does not allow friends teleporting to them.");
				return true;
			}
			
			player.teleport(targetFriend);
			targetFriend.sendMessage(ChatColor.WHITE+player.getDisplayName()+ChatColor.GRAY+" has teleported to you. You can disable this feature with the /friendconf command.");
			return true;
		}
		return false;
	}
	
}
