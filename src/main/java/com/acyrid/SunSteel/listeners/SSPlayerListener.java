package com.acyrid.SunSteel.listeners;

import com.acyrid.SunSteel.SunSteel;
import com.acyrid.SunSteel.utils.SSMechanics;
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
    private Map<Player, Set<Block>> revertMap = new HashMap<Player,Set<Block>>();
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Set<Block> revertSet = revertMap.get(player);
        if (revertSet == null) {
            revertSet = new LinkedHashSet<Block>();
            revertMap.put(player, revertSet);
        }
        if(SSMechanics.hasSSHoverWater(player)||SSMechanics.hasSSHoverLava(player)){
            Block toBlockLoc = event.getTo().getBlock();
            Block fromBlockLoc = event.getFrom().getBlock();
            if (!fromBlockLoc.equals(toBlockLoc)){
                final int range = 1;
                for (int dx = -range; dx <=range; dx++) {
                    for (int dz = -range; dz <=range; dz++) {
                        Block block = toBlockLoc.getRelative(dx, -1, dz);
                        if(((block.getType() == Material.WATER || block.getType() == Material.STATIONARY_WATER))&&
                                SSMechanics.hasSSHoverWater(player)){
                            if(Material.getMaterial(SSMechanics.getWaterWalkBlock()) != null){
                                if(SSMechanics.getNoCheatInstalled()){
                                    if(SSMechanics.getLavaWalkBlock()!=SSMechanics.getWaterWalkBlock()){
                                        block.setTypeId(SSMechanics.getWaterWalkBlock());
                                    }else{
                                        block.setType(Material.CLAY);
                                    }
                                }else{
                                        player.sendBlockChange(block.getLocation() ,Material.getMaterial(SSMechanics.getWaterWalkBlock()),(byte)0 );
                                }
                                revertSet.add(block);
                            }
                        }else if(((block.getType() == Material.LAVA || block.getType() == Material.STATIONARY_LAVA))&& SSMechanics.hasSSHoverLava(player)){
                            if(Material.getMaterial(SSMechanics.getLavaWalkBlock()) != null){
                                if(SSMechanics.getNoCheatInstalled()){
                                    block.setTypeId(SSMechanics.getLavaWalkBlock());
                                }else{
                                    player.sendBlockChange(block.getLocation() ,Material.getMaterial(SSMechanics.getLavaWalkBlock()),(byte)0 );
                                }
                                revertSet.add(block);
                            }
                        }
                    }
                }
            }
        }
        if(!revertSet.isEmpty()){
            revertCheck(player);
        }else if(!player.isOnline() || player.isDead()){
            if(!revertSet.isEmpty()&& revertSet.iterator().next().getType()==Material.WATER){
                revertCheck(player);
            }
        }
    }
    
    public void revertCheck(Player player){
        Block playerBlock = player.getLocation().getBlock();
        Iterator<Block> iterator = revertMap.get(player).iterator();
        while(iterator.hasNext()){
            Block nextBlock = iterator.next();
            int xCheck = abs(nextBlock.getX()) - abs(playerBlock.getX());
            int zCheck = abs(nextBlock.getZ()) - abs(playerBlock.getZ());
            if((abs(xCheck) > 3 || abs(zCheck) >3)){
                if(!SSMechanics.getNoCheatInstalled()){
                    player.sendBlockChange(nextBlock.getLocation(), nextBlock.getType(),(byte)0 );
                    iterator.remove();
                }else{
                    if(nextBlock.getTypeId()== SSMechanics.getLavaWalkBlock()){
                        nextBlock.setType(Material.LAVA);                        
                    }else if(nextBlock.getTypeId()== SSMechanics.getWaterWalkBlock() || nextBlock.getType()== Material.CLAY){
                        nextBlock.setType(Material.WATER);
                    }
                    iterator.remove();
                }
            }
        }
    }
}
