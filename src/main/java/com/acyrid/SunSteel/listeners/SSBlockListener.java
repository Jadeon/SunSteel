package com.acyrid.SunSteel.listeners;

import com.acyrid.SunSteel.SunSteel;
import com.acyrid.SunSteel.utils.SSMechanics;
import com.acyrid.SunSteel.utils.SSPermissions;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

public class SSBlockListener implements Listener {
    public SSBlockListener(SunSteel plugin){
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();

        if ((event.getBlock().getType() == Material.STONE || event.getBlock().getType() == Material.COBBLESTONE) && SSMechanics.hasSSPick(player) && SSPermissions.allowedPick(player) && SSMechanics.smeltChance())
        {
         smeltBlock(event, 1);
        }else if ((event.getBlock().getType() == Material.SAND) && SSMechanics.hasSSShovel(player) && SSPermissions.allowedPick(player) && SSMechanics.smeltChance()){
            smeltBlock(event, 20);
        }else if ((event.getBlock().getType() == Material.LOG) && SSMechanics.hasSSAxe(player) && SSPermissions.allowedAxe(player) && SSMechanics.smeltChance()){
            smeltBlock(event, 263);
        }else if ((event.getBlock().getType() == Material.IRON_ORE) && SSMechanics.hasSSPick(player) && SSPermissions.allowedPick(player) && SSMechanics.smeltChance()){
            smeltBlock(event, 265);
        }else if ((event.getBlock().getType() == Material.GOLD_ORE) && SSMechanics.hasSSPick(player) && SSPermissions.allowedPick(player) && SSMechanics.smeltChance()){
            smeltBlock(event, 266);
        }else if ((event.getBlock().getType() == Material.CLAY) && SSMechanics.hasSSShovel(player) && SSPermissions.allowedShovel(player) && SSMechanics.smeltChance()){
            smeltBlock(event, 336);
        }
    }
    
    public void smeltBlock(BlockBreakEvent event, int x){
        Location blLocation = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);;
        event.getBlock().getWorld().dropItem(blLocation, new ItemStack(x, 1));
        event.getBlock().setType(Material.AIR);
    }

}
