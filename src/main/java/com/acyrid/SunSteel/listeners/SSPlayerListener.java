package com.acyrid.SunSteel.listeners;

import com.acyrid.SunSteel.SunSteel;
import com.acyrid.SunSteel.utils.SSMechanics;
import com.google.common.collect.Iterators;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


import java.util.*;

import static java.lang.Math.abs;

public class SSPlayerListener implements Listener{
    public SSPlayerListener(SunSteel plugin) {
    }
    private Map<Player, Set<Block>> revertSet = new HashMap<Player,Set<Block>>();
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(SSMechanics.hasSSHoverWater(player)){
            if(!revertSet.containsKey(player)){
                revertSet.put(player,new HashSet<Block>());}
            HashSet<Block> reverts = new HashSet();
            Block toBlockLoc = event.getTo().getBlock();
            System.out.println("toBlockLoc = " + toBlockLoc + "\t");
            Block fromBlockLoc = event.getFrom().getBlock();
            System.out.println("fromBlockLoc = "+fromBlockLoc+"\n");
            if (!fromBlockLoc.equals(toBlockLoc)){
                final int range = 1;
                for (int dx = -range; dx <=range; dx++) {
                    System.out.println("dx = "+dx+"\t");
                    for (int dz = -range; dz <=range; dz++) {
                        System.out.println("dz = "+dz+"\n");                        
                        Block block = toBlockLoc.getRelative(dx, -1, dz);
                        System.out.println("block = " +block+"\t");
                        if(((block.getType() == Material.WATER || block.getType() == Material.STATIONARY_WATER))){
                            player.sendBlockChange(block.getLocation() ,Material.ICE,(byte)0 );
                            revertSet.get(player).add(block);
                            revertCheck(player);
                            
                        }
                    }
                }
            }

        }

    } 
    
    public void revertCheck(Player player){
        Set <Block> hashSet = new HashSet();
        Block playerBlock = player.getLocation().getBlock();
        Iterator<Block> iterator = revertSet.get(player).iterator();
        while(iterator.hasNext()){
            Block nextBlock = iterator.next();
            System.out.println("nextBlock[revert] = " +nextBlock+"\t");
            int xCheck = abs(nextBlock.getX()) - abs(playerBlock.getX());
            System.out.println("xCheck = " +xCheck+"\t");
            int zCheck = abs(nextBlock.getZ()) - abs(playerBlock.getZ());
            System.out.println("zCheck = " +zCheck+"\n");
            System.out.println("abs(xCheck) = " +abs(xCheck)+"\t abs(zCheck)"+abs(zCheck)+"\n");
            if((abs(xCheck) > 3 || abs(zCheck) >3)){
                player.sendBlockChange(nextBlock.getLocation(), Material.WATER,(byte)0 );
                iterator.remove();
            }
        }
    }
}

 /*[21:44] <Afforess|Away> Keep a HashSet<Block> and add blocks you send a block change for
[21:44] <Adisyn> ok i will look into that as I've never used a HashSet :)
[21:44] <Afforess|Away> then do a repeating task and if the player > 3 blocks away, send the real block back*/