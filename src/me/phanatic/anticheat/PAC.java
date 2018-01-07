package me.phanatic.anticheat;

import me.phanatic.anticheat.api.CheckData;
import me.phanatic.anticheat.listeners.ReachCheck;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class PAC extends JavaPlugin {

	public static HashMap<Player, CheckData> playerReachDat = new HashMap<>();

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new ReachCheck(), this);
	}

	@Override
	public void onDisable(){
	}


}