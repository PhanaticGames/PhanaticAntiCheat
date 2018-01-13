package me.phanatic.anticheat.listeners;

import me.phanatic.anticheat.PAC;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import src.me.phanatic.anticheat.api.CheckData;

/**
 * The primary listener class for reach checks
 */
public class ReachCheck implements Listener {

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
        playerWhoHit.sendMessage("" + distance);
        if (playerWhoHit.getLocation().getY() - playerHit.getLocation().getY() == 0) {
            MaxReach = 3.4713193295089497;
        }

        if (playerWhoHit.getLocation().getY() - playerHit.getLocation().getY() == 2) {
            MaxReach = 3.9649536556060863;
        }
        double walkspeed = playerWhoHit.getWalkSpeed();
        if (playerWhoHit.getWalkSpeed() == .2) {
            MaxReach = 4;

        }


        playerWhoHit.sendMessage("" + ChatColor.LIGHT_PURPLE + walkspeed);
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
            if (PAC.playerReachDat.containsKey(playerWhoHit)) {
                CheckData playerReach = PAC.playerReachDat.get(playerWhoHit);
                playerReach.addCheck();
                // TODO, ALL PHANATIC MESSAGES MUST BE READ FROM CONFIG
                playerWhoHit.sendMessage(ChatColor.RED + "You Have Flagged The Phanatic Anticheat");
            } else {
                CheckData reach = new CheckData();
                reach.setPlayer(playerWhoHit);
                PAC.playerReachDat.put(playerWhoHit, reach);
            }

        }

    }

    // TODO, use NMS based class loading
    public int getPing(Player player) {
        return ((CraftPlayer) player).getHandle().ping;
    }
}