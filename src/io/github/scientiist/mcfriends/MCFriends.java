package io.github.scientiist.mcfriends;

import org.bukkit.plugin.java.JavaPlugin;

public class MCFriends extends JavaPlugin {
	
	public static MCFriends pl;
	
	@Override
	public void onEnable() {
		pl = this;
	}
	
	@Override
	public void onDisable() {
		
	}
}
