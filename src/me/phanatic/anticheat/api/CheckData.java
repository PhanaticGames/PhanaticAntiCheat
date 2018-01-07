package me.phanatic.anticheat.api;

import org.bukkit.entity.Player;

/**
 * A sort of data store class
 */
public class CheckData {
	
	private Player player;

	private int checks;

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
