package com.acyrid.SunSteel.listeners;

import com.acyrid.SunSteel.SunSteel;
import com.acyrid.SunSteel.utils.SSMechanics;
import com.acyrid.SunSteel.utils.SSPermissions;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SSPlayerListener implements Listener{
    public SSPlayerListener(SunSteel plugin) {
    }
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();    
        Block blockLoc = player.getLocation().getBlock();
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] -------------------------------------------------------------------------------------------------------------\n");
            System.out.println("[SUNSTEEL-DEBUG] Player Move Event:" + blockLoc.getType()+"\n");
            System.out.println("[SUNSTEEL-DEBUG] Player Move Event by:" + event.getPlayer() +"\n");
            System.out.println("[SUNSTEEL-DEBUG] " + event.getPlayer().getName() + "'s allowedBoots is:"+SSPermissions.allowedBoots(player)+"\n");
            System.out.println("[SUNSTEEL-DEBUG] " + event.getPlayer().getName() + "'s allowedLavaHover is:"+SSPermissions.allowedLavaHover(player)+"\n");
            System.out.println("[SUNSTEEL-DEBUG] " + event.getPlayer().getName() + "'s allowedWaterHover is:"+SSPermissions.allowedWaterHover(player)+"\n");
            System.out.println("[SUNSTEEL-DEBUG] " + event.getPlayer().getName() + "'s hasSSBoots is:"+SSMechanics.hasSSBoots(player)+"\n");
            System.out.println("[SUNSTEEL-DEBUG] ------------------------------------------------------------------------------------------------------------\n");
        }
        if(((blockLoc.getType() == Material.WATER || blockLoc.getType() == Material.STATIONARY_WATER))){
            if(SSMechanics.hasSSHoverWater(player)){
                event.getTo().setY(event.getFrom().getY());
            }
        }
        if((blockLoc.getType() == Material.LAVA) || blockLoc.getType() == Material.STATIONARY_LAVA){
            if(SSMechanics.hasSSHoverLava(player)){
                event.getTo().setY(event.getFrom().getY());
            }

        }
    }
}
