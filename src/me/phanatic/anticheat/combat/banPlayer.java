package me.phanatic.anticheat.combat;

import org.bukkit.entity.Player;

public class banPlayer {

	public void ban() {

		if (Main.playerReachDat.get(playerWhoHit).getChecks() == 15) {
            banPlayer.checkReachCount(playerWhoHit);
        }
	}
}
