package src.me.phanatic.anticheat.api;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import src.me.phanatic.anticheat.PAC;

public class BanAPI {

    public static void checkReachCount(Player playerWhoHit) {
        if (PAC.playerReachDat.get(playerWhoHit).getChecks() == 15) {
        	playerWhoHit.kickPlayer(ChatColor.RED + "You've been caught cheating!");
        }
    }
}
