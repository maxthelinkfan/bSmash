package me.smash.Define;


import me.smash.Main.Main;
import me.smash.Main.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaSetting implements CommandExecutor {
	SettingsManager settings = SettingsManager.getInstance();
	
	@SuppressWarnings("unused")
	private Main plugin;
	public ArenaSetting(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("sbarena")) {
			
			Player p = (Player) sender;			
			if(args.length <= 0) {
				p.sendMessage(ChatColor.RED + "--");
			}
			if(args.length > 0){
			if(args[0].equalsIgnoreCase("set")) {
				if(settings.getData().contains("arenas." + args[1])) {
				settings.getData().set("arenas." + args[1] + ".x", Double.valueOf(p.getLocation().getX()));
				settings.getData().set("arenas." + args[1] + ".y", Double.valueOf(p.getLocation().getY()));
				settings.getData().set("arenas." + args[1] + ".z", Double.valueOf(p.getLocation().getZ()));
				sender.sendMessage(ChatColor.GREEN + "You have start point for arena " + args[1] + "!");
				settings.saveData();
				}
					
				}
			}
			}
		return false;
}
}