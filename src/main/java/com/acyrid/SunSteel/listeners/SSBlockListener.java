package com.acyrid.SunSteel.listeners;

import com.acyrid.SunSteel.utils.SSMechanics;
import com.acyrid.SunSteel.utils.SSPermissions;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class SSBlockListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(SSMechanics.smeltChance()){
            if(SSMechanics.hasSSPick(player) && SSPermissions.allowedPick(player)){
                if ((event.getBlock().getType() == Material.STONE || event.getBlock().getType() == Material.COBBLESTONE))
                {
                    smeltBlock(event, 1);
                }else if ((event.getBlock().getType() == Material.IRON_ORE)){
                    smeltBlock(event, 265);
                }else if ((event.getBlock().getType() == Material.GOLD_ORE)){
                    smeltBlock(event, 266);
                }
            }else if(SSMechanics.hasSSShovel(player) && SSPermissions.allowedShovel(player)){
                if ((event.getBlock().getType() == Material.SAND)){
                    smeltBlock(event, 20);
                }else if ((event.getBlock().getType() == Material.CLAY)){
                    smeltBlock(event, 45);
                }
            }else if (SSMechanics.hasSSAxe(player) && SSPermissions.allowedAxe(player)){
                if(event.getBlock().getType() == Material.LOG){
                    smeltBlock(event, 263);
                }
            }

        }
    }

    public void smeltBlock(BlockBreakEvent event, int x){
        Location blLocation = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);;
        event.getBlock().getWorld().dropItem(blLocation, new ItemStack(x, 1));
        event.getBlock().setType(Material.AIR);
     }
}
