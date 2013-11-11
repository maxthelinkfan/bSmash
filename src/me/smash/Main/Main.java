package me.smash.Main;


import me.smash.Events.SignLobbyEvent;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	SettingsManager settings = SettingsManager.getInstance();
	private SignLobbyEvent PlayerListener = new SignLobbyEvent(this);
	
	public void onEnable() {
		settings.setup(this);	
		
		PluginManager event = getServer().getPluginManager();
	    event.registerEvents(this.PlayerListener, this);
		
	}
	
	public void onDisable() {

}
}
