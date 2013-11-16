package me.smash.Events;

import java.util.ArrayList;

import me.smash.Main.Main;
import me.smash.Main.SettingsManager;

import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.Sign;
import org.bukkit.configuration.MemorySection;

public class SignLobbyEvent implements Listener{
	public ArrayList<String> lone = new ArrayList<String>();
	SettingsManager settings = SettingsManager.getInstance();
       
	@SuppressWarnings("unused")
	private Main plugin;
	public SignLobbyEvent(Main plugin) {
		this.plugin = plugin;
        }
	
        @EventHandler
        public void onPlayerInteract(PlayerInteractEvent e){
        final Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST){
            Sign sign = (Sign) e.getClickedBlock().getState();
            if(sign.getLine(0).equals(ChatColor.RED + "[Smash Lobby]")) {                			
            		if(!lone.contains(p.getName())){
            			if(!(lone.size() == 6)){
            		p.sendMessage(ChatColor.GREEN + "You have joined the " + sign.getLine(1) + " lobby!");
            		lone.add(p.getName());   
                		sign.setLine(2, lone.size() + "/" + "6");
                		sign.update();   
                		
                			
                		}
            	}
            }
            }
            	}
            }
            
       
        
              				

	@EventHandler
	public void onSignChange(SignChangeEvent e){
	 Player p = e.getPlayer();
    if(e.getLine(0).equals("[Smash Lobby]")) {        		    	
    	if(e.getLine(2).equals("2")) {
    		e.setLine(2, lone.size() + "/" + "6");
    		e.setLine(0, ChatColor.RED + "[Smash Lobby]");
    		if(settings.getData().getString(e.getLine(1)) == null){
    		settings.getData().set("arenas." + e.getLine(1) + ".x", "");
    		settings.getData().set("arenas." + e.getLine(1) + ".y", "");
    		settings.getData().set("arenas." + e.getLine(1) + ".z", "");
    		p.sendMessage(ChatColor.GREEN + "Arena " + e.getLine(1) + " has been created!");
    		settings.saveData();
    		
        }
        }
        }
	}
}


