package me.phanatic.anticheat;

import java.util.HashMap;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static HashMap<Player, ReachAdd> playerReachDat = new HashMap<Player, ReachAdd>();

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Reach(), this);
	}

	@Override
	public void onDisable() {
	}


}