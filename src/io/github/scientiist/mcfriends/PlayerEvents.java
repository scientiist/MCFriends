package io.github.scientiist.mcfriends;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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
	
	
	@EventHandler
	public void onPlayerAttack(EntityDamageByEntityEvent e) {
		if ((e.getDamager() instanceof Player) && (e.getEntity() instanceof Player)) {
			
			Player victim = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			
			
			YamlConfiguration config = YamlFileIO.getPlayerConfig(attacker);
			
			if (config.getStringList("friends").contains(victim.getUniqueId().toString())) {
				attacker.sendMessage(ChatColor.RED+"You cannot attack friends!");
				e.setCancelled(true);
			}
				
		}
	}
}
