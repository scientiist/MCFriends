package io.github.scientiist.mcfriends;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEvents implements Listener {
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = (Player) e.getPlayer();
		
		YamlConfiguration cfg = YamlFileIO.getPlayerConfig(p);
		
		
		cfg.set("lastseenusername", p.getDisplayName());
		
		
		if (p.hasPlayedBefore() != true) {
			cfg.set("config.allowfriendteleport", true);
		}
		
		YamlFileIO.setPlayer(p, cfg);
	}
}
