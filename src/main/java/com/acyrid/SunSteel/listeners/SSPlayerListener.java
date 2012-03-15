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
        if((SSMechanics.hasSSBoots(player)))
        {
                if(((blockLoc.getType() == Material.WATER || blockLoc.getType() == Material.STATIONARY_WATER)&&(SSMechanics.hasSSHoverWater(player)))
                        ||((blockLoc.getType() == Material.LAVA) || blockLoc.getType() == Material.STATIONARY_LAVA)&&(SSMechanics.hasSSHoverLava(player))){
                    event.getTo().setY(event.getFrom().getY());

                }

        }
    }
}
