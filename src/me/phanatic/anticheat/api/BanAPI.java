package me.phanatic.anticheat.api;

import me.phanatic.anticheat.PAC;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class BanAPI {

    public static void checkReachCount(Player playerWhoHit) {
        CheckData cD = PAC.playerReachDat.get(playerWhoHit);
        if (cD.getChecks() == 15) {
        	playerWhoHit.kickPlayer(ChatColor.RED + "You've been caught cheating!");
        }
    }
}
