package io.github.scientiist.mcfriends;

import java.util.List;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ChatCommands implements CommandExecutor {
	
	
	
	private void errPlayerGone() {
		
	}
	
	private void errSenderNotPlayer() {
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		
		
		String command = cmd.getName().toLowerCase();
		if (command.equals("addfriend")) {
			
			if (!(sender instanceof Player)) { return false;}
			if (!(args.length > 1)) { return false; }
			
			Player player = (Player) sender;
			
			Player targetFriend = MCFriends.pl.getServer().getPlayer(args[0]);
			
			if (targetFriend != null) {
				
				// add targetFriend to his friend list
				YamlConfiguration config = YamlFileIO.getPlayerConfig(player);
				
				List<String> l = config.getStringList("friends");
				
				String friendUUID = targetFriend.getUniqueId().toString();
				
				if (l.contains(friendUUID)) {
					
					return false;
				}
				
				l.add(friendUUID);
				
					
				
			}
		}
		
		if (command.equals("delfriend")) {

		}
		
		if (command.equals("friendlist")) {
		
		}
		
		if (command.equals("friendconf")) {

		}
		
		if (command.equals("tofriend")) {
			
		}
		
		
		return false;
	}

}
