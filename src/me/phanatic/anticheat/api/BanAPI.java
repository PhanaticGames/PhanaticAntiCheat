package me.phanatic.anticheat.api;

import me.phanatic.anticheat.PAC;
import org.bukkit.entity.Player;

public class BanAPI {

    public static void checkReachCount(Player playerWhoHit) {
        if (PAC.playerReachDat.get(playerWhoHit).getChecks() == 15) {
            // TODO, USE PSC API TO BAN PLAYER TO DATABASE
            // YOU WILL DO THISYOURSELF
        }
    }
}
