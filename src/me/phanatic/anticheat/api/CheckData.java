package me.phanatic.anticheat;

import org.bukkit.entity.Player;

/**
 * A sort of data store class
 */
public class checkAdd {
	
	public Player player;

	public int checks;

    /**
     * Set player refrence
     * @param p Player who hit
     */
	public void setPlayer(Player p) {
		player = p;
	}

	/**
	 * Add 1 check to the players current check count
	 */
	public void addCheck() {
		checks = checks++;
	}

    /**
     * Get the current check count
     * @return int Check count for the player
     */
	public int getChecks() {
		return checks;
	}

}
