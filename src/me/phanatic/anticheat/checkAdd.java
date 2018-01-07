package me.phanatic.anticheat;

import org.bukkit.entity.Player;

/**
 * A sort of data store class
 */
public class checkAdd {
	
	public Player player;
	public int checks;
	//sets player
	public void setPlayer(Player p) {
		player = p;
	}
	//adds checks when player is thought to be cheating 
	public void addCheck() {
		checks = checks++;
	}

	// Make getPlayer
	public int getChecks() {
		return checks;
	}
		//gets the amount of checks a player has
		

}
