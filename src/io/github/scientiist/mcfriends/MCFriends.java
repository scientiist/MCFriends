package io.github.scientiist.mcfriends;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.scientiist.mcfriends.commands.AddFriend;
import io.github.scientiist.mcfriends.commands.ToFriend;

public class MCFriends extends JavaPlugin {
	
	public static MCFriends pl;
	
	@Override
	public void onEnable() {
		pl = this;
		
		getCommand("addfriend").setExecutor(new AddFriend());
		getCommand("tofriend").setExecutor(new ToFriend());
		
		getDataFolder().mkdirs();
	}
	
	@Override
	public void onDisable() {
		
	}
}
