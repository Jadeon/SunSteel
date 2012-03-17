package com.acyrid.SunSteel.utils;


import com.acyrid.SunSteel.SunSteel;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class SSMechanics {

    public static SunSteel plugin;

    public static void init(SunSteel plugin) {
        SSMechanics.plugin = plugin;
    }
    
    public static boolean hasSSArmor(Player player){
        return (hasSSChest(player) && SSPermissions.allowedChest(player))
                && (hasSSLegs(player) && SSPermissions.allowedPants(player))
                && (hasSSHelm(player) && SSPermissions.allowedHelm(player))
                && (hasSSBoots(player)&& SSPermissions.allowedBoots(player));
    }
    public static boolean hasSSHelm(Player player){
        ItemStack item = player.getInventory().getHelmet();
        System.out.println("SSMechancis Line:24 getHelmet(): "+item);
        System.out.println("Helmet ID: "+item.getTypeId());
        System.out.println("Config Helm ID: "+plugin.getConfig().getInt(SSConfig.helmId));
        if (item != null){
            return player.getInventory().getHelmet().getTypeId() == plugin.getConfig().getInt(SSConfig.helmId);
        }else{return false;}
    }

    public static boolean hasSSChest(Player player){
        ItemStack item = player.getInventory().getChestplate();
        System.out.println("SSMechancis Line:34 getChestplate(): "+item);
        System.out.println("Chest ID: "+item.getTypeId());
        System.out.println("Config Chest ID: "+plugin.getConfig().getInt(SSConfig.chestId));
        if (item != null){
            return player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId);
        }else{return false;}
    }

    public static boolean hasSSLegs(Player player){
        ItemStack item = player.getInventory().getLeggings();
        System.out.println("SSMechancis Line:44 getLeggings(): "+item);
        System.out.println("Leggings ID: "+item.getTypeId());
        System.out.println("Config Leggings ID: "+plugin.getConfig().getInt(SSConfig.legsId));
        if (item != null){
            return player.getInventory().getLeggings().getTypeId() == plugin.getConfig().getInt(SSConfig.legsId);
        }else{return false;}
    }

    public static boolean hasSSBoots(Player player){
        ItemStack item = player.getInventory().getBoots();
        if (item != null){
            return item.getTypeId() == plugin.getConfig().getInt(SSConfig.bootsId);
        }else{return false;}
    }

    public static boolean hasSSSword(Player player){
        System.out.println("SSMechancis Line:63 getItemInHand(): "+player.getInventory().getItemInHand());
        System.out.println("ItemInHand ID: "+getHeldItem(player));
        System.out.println("Config Sword ID: "+plugin.getConfig().getInt(SSConfig.swordId));
        return getHeldItem(player) == plugin.getConfig().getInt(SSConfig.swordId);
    }

    public static boolean hasSSAxe(Player player){
        System.out.println("SSMechancis Line:70 getItemInHand(): "+player.getInventory().getItemInHand());
        System.out.println("ItemInHand ID: "+getHeldItem(player));
        System.out.println("Config Axe ID: "+plugin.getConfig().getInt(SSConfig.axeId));
        return getHeldItem(player) == plugin.getConfig().getInt(SSConfig.axeId);
        }

    public static boolean hasSSPick(Player player){
        System.out.println(plugin.getConfig().getKeys(true));
        System.out.println(plugin.getConfig().get(SSConfig.pickId));
        System.out.println(SSConfig.pickId);
        System.out.println("SSMechancis Line:77 getItemInHand(): "+player.getInventory().getItemInHand());
        System.out.println("ItemInHand ID: "+getHeldItem(player));
        System.out.println("Config Pick ID: "+plugin.getConfig().getInt(SSConfig.pickId));
        return getHeldItem(player) == plugin.getConfig().getInt(SSConfig.pickId);
    }
    public static boolean hasSSShovel(Player player){
        System.out.println("SSMechancis Line:83 getItemInHand(): "+player.getInventory().getItemInHand());
        System.out.println("ItemInHand ID: "+getHeldItem(player));
        System.out.println("Config Shovel ID: "+plugin.getConfig().getInt(SSConfig.shovelId));
        return getHeldItem(player) == plugin.getConfig().getInt(SSConfig.shovelId);
    }

    public static boolean hasSSWeapon(Player player){
        if(SSMechanics.getDebugMode()){

        }
        return (hasSSSword(player) && SSPermissions.allowedSword(player))
                || (hasSSAxe(player) && SSPermissions.allowedAxe(player));
    }
    
    public static boolean hasSSHoverLava(Player player){
        return (hasSSBoots(player) && SSPermissions.allowedBoots(player) && SSPermissions.allowedLavaHover(player));
    }
    /*public static boolean hasSSLavaBreath(Player player){
        return (hasSSChest(player) && SSPermissions.allowedChest(player) && SSPermissions.allowedLavaBreath(player));
    }*/
    public static boolean hasSSWaterBreath(Player player){
        return (hasSSChest(player) && SSPermissions.allowedChest(player) && SSPermissions.allowedWaterBreath(player));
    }

    public static boolean hasSSHoverWater(Player player){
        return (hasSSBoots(player) && SSPermissions.allowedBoots(player) && SSPermissions.allowedWaterHover(player));
    }
    
    public static int getHeldItem(Player player){
        ItemStack item = player.getInventory().getItemInHand();
        if (item != null){
            return player.getInventory().getItemInHand().getTypeId();
        }else{return 0;}
    }
    public static boolean hitChance() {
        double luck =  Math.random()*100;
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [hitChance()]: "+ (getHitChance() >= luck));
        }
        return (getHitChance() >= luck);
    }

    public static int getHitChance(){
        return plugin.getConfig().getInt(SSConfig.hitChance);
    }
    public static boolean smeltChance() {
        double luck =  Math.random()*100;
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [smeltChance()]: "+ (getSmeltChance() >= luck));
        }
        return (getSmeltChance() >= luck);
    }

    public static int getSmeltChance(){
        return plugin.getConfig().getInt(SSConfig.smeltChance);
    }

    public static int fireTicks(){
        return (getFireTicks()*20);
    }

    public static int getFireTicks(){
        return plugin.getConfig().getInt(SSConfig.fireDuration);
    }

    public static int riposteTicks(){
        return (getRiposteTicks()*20);
    }
    public static int getRiposteTicks(){
        return plugin.getConfig().getInt(SSConfig.riposteDuration);
    }
    
    public static boolean getDebugMode(){
        return plugin.getConfig().getBoolean(SSConfig.debugMode);
    }
    

}
