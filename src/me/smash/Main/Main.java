package me.smash.Main;


import java.util.ArrayList;
import me.smash.Define.ArenaSetting;
import me.smash.Events.SignLobbyEvent;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	SettingsManager settings = SettingsManager.getInstance();
	private SignLobbyEvent PlayerListener = new SignLobbyEvent(this);
	private ArenaSetting executor;
	
	public void onEnable() {
		settings.setup(this);	
		
		executor = new ArenaSetting(this);
		getCommand("sbarena").setExecutor(executor);
		
		PluginManager event = getServer().getPluginManager();
	    event.registerEvents(this.PlayerListener, this);
	}
	
	public void onDisable() {

}
}
