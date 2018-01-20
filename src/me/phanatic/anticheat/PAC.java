package me.phanatic.anticheat;

import me.phanatic.anticheat.api.CheckData;
import me.phanatic.anticheat.listeners.ReachCheck;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class PAC extends JavaPlugin {

    /**
     * This can be accessed ANYWHERE
     * Hint what ReachCheck does. This is static
     * This PAC.playerReachDat can be accessed from ANY class
     * So, In KA check, just use PAC.playerReachDat.get(PLAYER);
     */
	public static HashMap<Player, CheckData> playerReachDat = new HashMap<>();

	@EventHandler
	public void onEntity(EntityDamageByEntityEvent event) {
		if (!(event.getDamager() instanceof Player))
			return;
		if (!(event.getEntity() instanceof Player))
			return;

		Player playerWhoHit = (Player) event.getDamager();
		Player playerHit = (Player) event.getEntity();
	}
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new ReachCheck(), this);
	}

	@Override
	public void onDisable(){
	}


}