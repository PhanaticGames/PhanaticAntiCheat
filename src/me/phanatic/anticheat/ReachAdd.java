package me.phanatic.anticheat;

import org.bukkit.entity.Player;

/**
 * A sort of data store class
 */
public class ReachAdd {
	
	public Player player;
	public int checks;

	public void setPlayer(Player p) {
		player = p;
	}

	public void addCheck() {
		checks = checks++;
	}

	// Make getPlayer
	public int getChecks() {
		return checks;
	}
}