package me.smash.Events;

import java.util.ArrayList;

import me.smash.Main.Main;

import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.Sign;

public class SignLobbyEvent implements Listener{
	public ArrayList<String> lone = new ArrayList<String>();
 
       
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
            if(sign.getLine(0).equals("[Smash Lobby]")) {
            	if(sign.getLine(1).equals("1")){
            		if(!lone.contains(p.getName())){
            			if(!(lone.size() == 6)){
            		p.sendMessage(ChatColor.GREEN + "You have joined lobby " + sign.getLine(1) + "!");
            		lone.add(p.getName());   
                		sign.setLine(2, lone.size() + "/" + "6");
                		sign.update();
                	
            	}
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
    	if(e.getLine(1).equals("1")){         		    	
    	if(e.getLine(2).equals("2")) {
    		e.setLine(2, lone.size() + "/" + "6");
    		
        }
        }
        }
	}
	}
