package me.phanatic.anticheat;

import java.util.HashMap;
import org.bukkit.plugin.java.JavaPlugin;

import me.phanatic.anticheat.combat.Reach;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static HashMap<Player, checkAdd> playerReachDat = new HashMap<Player, checkAdd>();

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Reach(), this);
	}

	@Override
	public void onDisable(){
	}


}