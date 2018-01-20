package me.phanatic.anticheat;

import me.phanatic.anticheat.api.CheckData;
import me.phanatic.anticheat.listeners.KillAuraCheck;
import me.phanatic.anticheat.listeners.ReachCheck;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class PAC extends JavaPlugin {

    /**
     * This can be accessed ANYWHERE
     * Hint what ReachCheck does. This is static
     * This PAC.playerReachDat can be accessed from ANY class
     * <p>
     * SO, A hashmap is like a key that unlocks data
     * We store the "key" and the data
     * When we want to get data. We need a key
     * Here, We declare player as the "key". So playerWhoHit = the key
     * Give this the key and it gives the the players check Data
     */
    public static HashMap<Player, CheckData> playerReachDat = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ReachCheck(), this);
        getServer().getPluginManager().registerEvents(new KillAuraCheck(), this);
    }

    @Override
    public void onDisable() {
    }


}