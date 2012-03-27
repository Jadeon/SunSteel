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
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.List;

public class SSBlockListener implements Listener {

    private SunSteel plugin;

    public SSBlockListener(SunSteel plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if (!SSMechanics.smeltChance()) {
            return;
        }
        switch (event.getBlock().getType()) {
            case STONE:
                if (!SSMechanics.hasSSPick(player) || !SSPermissions.allowedPick(player)) {
                    return;
                }
                smeltBlock(event, Material.COBBLESTONE, Material.STONE);
                break;
            case COBBLESTONE:
                if (!SSMechanics.hasSSPick(player) || !SSPermissions.allowedPick(player)) {
                    return;
                }
                smeltBlock(event, Material.COBBLESTONE, Material.STONE);
                break;
            case SAND:
                if (!SSMechanics.hasSSShovel(player) || !SSPermissions.allowedShovel(player)) {
                    return;
                }
                smeltBlock(event, Material.SAND, Material.GLASS);
                break;
            case LOG:
                if (!SSMechanics.hasSSAxe(player) || !SSPermissions.allowedAxe(player)) {
                    return;
                }
                smeltBlock(event, Material.LOG, Material.COAL);
                break;
            case IRON_ORE:
                if (!SSMechanics.hasSSPick(player) || !SSPermissions.allowedPick(player)) {
                    return;
                }
                smeltBlock(event, Material.IRON_ORE, Material.IRON_INGOT);
                break;
            case GOLD_ORE:
                if (!SSMechanics.hasSSPick(player) || !SSPermissions.allowedPick(player)) {
                    return;
                }
                smeltBlock(event, Material.GOLD_ORE, Material.GOLD_INGOT);
                break;
            case CLAY:
                if (!SSMechanics.hasSSShovel(player) || !SSPermissions.allowedShovel(player)) {
                    return;
                }
                smeltBlock(event, Material.CLAY_BALL, Material.CLAY_BRICK);
                break;
            default:
                return;
        }
    }

    public void smeltBlock(BlockBreakEvent event, Material oldMaterial, Material newMaterial) {
        smeltBlock(event, oldMaterial, newMaterial, 1);
    }
    
    public void smeltBlock(BlockBreakEvent event, Material oldMaterial, Material newMaterial, int requiredOldForNew) {
        List<ItemStack> oldItems = new LinkedList<ItemStack>();
        List<ItemStack> newItems = new LinkedList<ItemStack>();
        for (ItemStack item : event.getDrops()) {
            if (item.getType() == oldMaterial) {
                oldItems.add(item);
                int newAmount = item.getAmount() / requiredOldForNew;
                newItems.add(new ItemStack(newMaterial, newAmount));
            }
        }
        event.getDrops().removeAll(oldItems);
        event.getDrops().addAll(newItems);
    }
}
