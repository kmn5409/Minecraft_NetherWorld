package com.keanunichols.NetherWorld;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NetherSpawn{
	
	private EntityType[] array;
	
	public NetherSpawn(){
		this.array = new EntityType[] {EntityType.BLAZE, EntityType.GHAST,EntityType.HOGLIN,EntityType.MAGMA_CUBE,EntityType.PIGLIN,
	              EntityType.PIGLIN_BRUTE, EntityType.STRIDER, EntityType.WITHER_SKELETON,EntityType.ZOGLIN,
			      EntityType.ZOMBIFIED_PIGLIN};
	}
	
	//Go about adding entity around location
	
	public void SpawnCreatures(Player plr, Random rand){
		//Player plr = Bukkit.getPlayer("KeanuNichols");
		List<Entity> entities = plr.getNearbyEntities(100, 100, 100);
		plr.sendMessage("Fired");
		Chunk chunk = plr.getLocation().getChunk();
		//Random rand = new Random();
		int y = plr.getLocation().getBlockY();
		Location randLoc = chunk.getBlock(rand.nextInt(16), y,rand.nextInt(16)).getLocation();
		//World wld = Bukkit.getPlayer("KeanuNichols").getWorld();
		World wld = plr.getWorld();
		int rnd = new Random().nextInt(array.length);
		EntityType ent = this.array[rnd];
		wld.spawnEntity(randLoc, ent);
		plr.sendMessage("" + ent.getName());
		/*
		for(Entity ent: entities){
			String name = ent.getName();
			if(ent.getType() == EntityType.COW || ent.getType() == EntityType.SHEEP || ent.getType() == EntityType.CHICKEN || 
					 ent.getType() == EntityType.PIG){
				plr.sendMessage(name);
			}
		}
		*/
		
	}

}
