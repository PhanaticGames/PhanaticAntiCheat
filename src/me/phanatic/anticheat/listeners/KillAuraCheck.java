package me.phanatic.anticheat.listeners;

import me.phanatic.anticheat.PAC;
import me.phanatic.anticheat.api.CheckData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * The primary listener call for killaura
 */
public class KillAuraCheck implements Listener {

    @EventHandler
    public static void checkA(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player))
            return;
        if (!(event.getEntity() instanceof Player))
            return;

        Player playerWhoHit = (Player) event.getDamager();
        Player playerHit = (Player) event.getEntity();

        CheckData dat = PAC.playerReachDat.get(playerWhoHit);

        if (dat == null) {
            dat = new CheckData();
            dat.setPlayer(playerWhoHit);
            dat.setTarget(playerHit);
            PAC.playerReachDat.put(playerWhoHit, dat);
        }

        double difference = Math.abs(playerHit.getLocation().getYaw() - playerWhoHit.getLocation().getYaw());

        if (dat.getLastDiff() == difference) {
            return;
        }

        if (difference > 2.0) {
            double differenceFinal = Math.abs(dat.getLastDiff() - difference);
            if (differenceFinal < 3.0) {
                dat.addKACheck();
            }
        }

    }
}
