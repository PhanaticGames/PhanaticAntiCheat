package me.phanatic.anticheat.combat;

import java.util.HashMap;

// TODO, use NMS based class loading
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.phanatic.anticheat.Main;
import me.phanatic.anticheat.checkAdd;
import net.md_5.bungee.api.ChatColor;

/**
 * The primary listeners class
 */
public class Reach implements Listener{

	@EventHandler
	public void onEntity(EntityDamageByEntityEvent event) {
		if (!(event.getDamager() instanceof Player))
			return;
		if (!(event.getEntity() instanceof Player))
			return;

		  Player playerWhoHit = (Player) event.getDamager();
		  Player playerHit = (Player) event.getEntity();
	
		double distance = playerWhoHit.getLocation().distance(playerHit.getLocation());
		
		double MaxReach = 3.4713193295089497;
		
		if(playerWhoHit.getLocation().getY() - playerHit.getLocation().getY() == 0){
			MaxReach = 3.4713193295089497;
			}
		
		if(playerWhoHit.getLocation().getY() - playerHit.getLocation().getY() == 2){
			MaxReach = 3.9649536556060863;
			}
		
		
		//playerWhoHit.sendMessage("" + distance);
		
		if (getPing(playerWhoHit) >= 100 && getPing(playerWhoHit) < 200) {
			MaxReach += 0.2; 
		} else if (getPing(playerWhoHit) >= 200 && getPing(playerWhoHit) < 250) {
			MaxReach += 0.4;
		} else if (getPing(playerWhoHit) >= 250 && getPing(playerWhoHit) < 300) {
			MaxReach += 0.8;
		} else if (getPing(playerWhoHit) >= 300 && getPing(playerWhoHit) < 350) {
			MaxReach += 1.2;
		} else if (getPing(playerWhoHit) >= 350 && getPing(playerWhoHit) < 400) {
			MaxReach += 1.5;
		} else if (getPing(playerWhoHit) > 400) {
			return;
		}

		if (distance > MaxReach) {
			if (Main.playerReachDat.containsKey(playerWhoHit)) {
				checkAdd playerReach = Main.playerReachDat.get(playerWhoHit);
				playerReach.addCheck();
				playerWhoHit.sendMessage(ChatColor.RED + "You Have Flagged The Phanatic Anticheat");
			}

			else {
				checkAdd reach = new checkAdd();
				reach.setPlayer(playerWhoHit);
				Main.playerReachDat.put(playerWhoHit, reach);
			}
		}

	}


	public int getPing(Player player) {
		return ((CraftPlayer) player).getHandle().ping;
	}
}