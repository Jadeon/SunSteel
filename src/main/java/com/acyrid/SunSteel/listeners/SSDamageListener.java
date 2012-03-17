package com.acyrid.SunSteel.listeners;

import com.acyrid.SunSteel.SunSteel;
import com.acyrid.SunSteel.utils.SSConfig;
import com.acyrid.SunSteel.utils.SSMechanics;
import com.acyrid.SunSteel.utils.SSPermissions;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class SSDamageListener implements Listener {

    protected static java.util.Vector<Animals> cookedAnimals = new java.util.Vector<Animals>(24);

    public SSDamageListener(SunSteel plugin) {
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDeath(EntityDeathEvent event){
        if(event.getEntity() instanceof Animals){
            if(cookedMeat((Animals)event.getEntity())){
                burnAnimal((Animals) event.getEntity());
                Set<ItemStack> newDrops = new HashSet<ItemStack>();
                for (ItemStack item : event.getDrops()) {
                    if(item.getType() == Material.RAW_BEEF){
                        newDrops.add(new ItemStack(Material.COOKED_BEEF));
                    }else if(item.getType() == Material.RAW_CHICKEN){
                        newDrops.add(new ItemStack(Material.COOKED_CHICKEN));
                    }else if(item.getType() == Material.RAW_FISH){
                        newDrops.add(new ItemStack(Material.COOKED_FISH));
                    } else {
                        newDrops.add(item);
                    }
                }
                event.getDrops().clear();
                event.getDrops().addAll(newDrops);
            }
        }
    }


    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if(event.isCancelled())
            return;
        if(event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent entityDamageByEntityEvent = (EntityDamageByEntityEvent) event;
            Entity aggressor = entityDamageByEntityEvent.getDamager();
            //Allows player fire proc effect if using configuration based weapon (sword | axe)
            if(aggressor instanceof Player) {
                Player player = (Player) aggressor;
                if (SSMechanics.hasSSWeapon(player) && SSMechanics.hitChance()){
                    event.getEntity().setFireTicks(SSMechanics.fireTicks());
                }
                if(event.getEntity() instanceof Animals)
                {
                    burnAnimal((Animals) event.getEntity());
                }
            }
            //Allows player fire riposte if using configuration based full set of armor
            if(event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                if (SSMechanics.hasSSArmor(player) && SSMechanics.hitChance()) {
                    aggressor.setFireTicks(SSMechanics.riposteTicks());
                }
            }
        }
        else if((event.getCause() == EntityDamageEvent.DamageCause.FIRE)
                || (event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)
                || (event.getCause() == EntityDamageEvent.DamageCause.LAVA)){
            if(event.getEntity() instanceof Animals){
                burnAnimal((Animals) event.getEntity());
            }
            //Allows player fire resistance effect if wearing configuration based full set of armor
            if(event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                if (SSMechanics.hasSSArmor(player) && SSMechanics.hitChance()) {
                    event.setCancelled(true);
                    player.setFireTicks(0);
                }
            }                
        }
        //Allows player water-breathing effect if wearing configuration based chestplate
        if((event.getCause() == EntityDamageEvent.DamageCause.DROWNING) && event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if(SSMechanics.hasSSWaterBreath(player)){
                player.setRemainingAir(player.getMaximumAir());
                event.setCancelled(true);

            }
        }
    }


    public static boolean cookedMeat(Animals animals) {
        if(animals != null){
            if(cookedAnimals.contains(animals)) {
                cookedAnimals.remove(animals);
                return true;
            } else return false;
        }else return false;
    }

    public static void burnAnimal(Animals animals) {
        if(!cookedAnimals.contains(animals)) {
            cookedAnimals.add(animals);
        }
    }
    
}
