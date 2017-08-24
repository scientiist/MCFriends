package io.github.scientiist.mcfriends;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class YamlFileIO {
	
	private static YamlConfiguration getFile(String filename) {
		YamlConfiguration f = YamlConfiguration.loadConfiguration(new File(MCFriends.pl.getDataFolder()+"/"+filename+".yml"));
		
		return f;
	}
	
	private static void setFile(String filename, YamlConfiguration conf) {
		File f = new File(MCFriends.pl.getDataFolder()+"/"+filename+".yml");
		
		try {
			conf.save(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
	}
	
	// library
	public static YamlConfiguration getPlayerConfig(Player player) {
		YamlConfiguration list = getFile("users/"+player.getUniqueId()+".yml");
		return list;
	}
	
	public static void setPlayer(Player player, YamlConfiguration list) {
		setFile("users/"+player.getUniqueId()+".yml", list);
	}
}
