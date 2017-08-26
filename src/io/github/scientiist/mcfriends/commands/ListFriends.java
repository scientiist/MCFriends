package io.github.scientiist.mcfriends.commands;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import io.github.scientiist.mcfriends.MCFriends;
import io.github.scientiist.mcfriends.YamlFileIO;

public class ListFriends implements CommandExecutor {
	

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		
		
		String command = cmd.getName().toLowerCase();
		if (command.equals("listfriends")) {
			

			if (!(sender instanceof Player)) { 
				sender.sendMessage(ChatColor.RED+"ERROR: Only players should use this command.");
				return true;
			}
			
			Player player = (Player) sender;
			
			
			YamlConfiguration list = YamlFileIO.getPlayerConfig(player);
			
			for (String str : list.getStringList("friends")) {
				UUID id = UUID.fromString(str);
				
				OfflinePlayer p = MCFriends.pl.getServer().getOfflinePlayer(id);
				
				
				if (p.isOnline()) {
					Player target = p.getPlayer();
					YamlConfiguration list2 = YamlFileIO.getPlayerConfig(player);
					
					if (list2.getStringList("friends").contains(player.getUniqueId().toString())) {
						player.sendMessage(ChatColor.GREEN+target.getDisplayName()+ " (MUTUAL)");
					} else {
						player.sendMessage(ChatColor.BLUE+target.getDisplayName());
					}
					
					
				} else {
					player.sendMessage(ChatColor.GRAY+p.getName()+" (OFFLINE)");
				}
			}
			
			return true;
			
		}
		
		return false;
	}
}