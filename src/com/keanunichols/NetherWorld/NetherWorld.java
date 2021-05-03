package com.keanunichols.NetherWorld;


import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NetherWorld extends JavaPlugin {
	
	
	public long randomNumberTime(){
		long leftLimit = 100L;
	    long rightLimit = 600L;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		return generatedLong;
	}
	
	@Override
    public void onEnable() {
		for (Player online : Bukkit.getServer().getOnlinePlayers()) {
            Player plr = Bukkit.getPlayer(online.getName());
        	plr.sendMessage("Hello");
        }
		//getServer().getPluginManager().registerEvents(new NetherSpawn(), this);
		
		JavaPlugin plugin = this;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            public void run()
            {			
            	int numPlayers = Bukkit.getOnlinePlayers().size();
            	Object[] plrs = Bukkit.getOnlinePlayers().toArray();
            	int size = plrs.length;
            	if(size > 0){
            		Random rand = new Random(); 
                	int n = rand.nextInt(plrs.length); 
            		//int random = new Random().nextInt(numPlayers);
            		//Player player = (Player)Bukkit.getOnlinePlayers().toArray()[random];
            		NetherSpawn ns = new NetherSpawn();
            		ns.SpawnCreatures((Player)plrs[n], rand);
            	}
            }
        }, 20L, randomNumberTime());
    }
    @Override
    public void onDisable() {
    }
}
