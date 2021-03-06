package io.github.scientiist.mcfriends;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.scientiist.mcfriends.commands.AddFriend;
import io.github.scientiist.mcfriends.commands.DelFriend;
import io.github.scientiist.mcfriends.commands.FriendConf;
import io.github.scientiist.mcfriends.commands.ListFriends;
import io.github.scientiist.mcfriends.commands.ToFriend;

public class MCFriends extends JavaPlugin {
	
	public static MCFriends pl;
	
	@Override
	public void onEnable() {
		pl = this;
		
		getCommand("addfriend").setExecutor(new AddFriend());
		getCommand("tofriend").setExecutor(new ToFriend());
		getCommand("friendconf").setExecutor(new FriendConf());
		getCommand("delfriend").setExecutor(new DelFriend());
		getCommand("listfriends").setExecutor(new ListFriends());
		
		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
		
		getDataFolder().mkdirs();
	}
	
	@Override
	public void onDisable() {
		
	}
}
