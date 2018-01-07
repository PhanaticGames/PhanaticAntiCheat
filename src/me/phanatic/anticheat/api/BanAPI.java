package me.phanatic.anticheat.combat;

public class BanAPI {

    public static void checkReachCount() {
        if (PAC.playerReachDat.get(playerWhoHit).getChecks() == 15) {
            // TODO, USE PSC API TO BAN PLAYER TO DATABASE
            // YOU WILL DO THISYOURSELF
        }
    }
}
