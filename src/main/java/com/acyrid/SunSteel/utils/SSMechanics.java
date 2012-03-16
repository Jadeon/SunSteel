package com.acyrid.SunSteel.utils;


import com.acyrid.SunSteel.SunSteel;
import org.bukkit.entity.Player;


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
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [hasSSHelm:]: "+player.getInventory().getHelmet() != null
                    && player.getInventory().getHelmet().getTypeId() == plugin.getConfig().getInt(SSConfig.helmId));
        }
        return player.getInventory().getHelmet() != null
                && player.getInventory().getHelmet().getTypeId() == plugin.getConfig().getInt(SSConfig.helmId);

    }

    public static boolean hasSSChest(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [hasSSChest]: "+player.getInventory().getChestplate() != null
                && player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId));
        }
        return player.getInventory().getChestplate() != null
                && player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId);

    }

    public static boolean hasSSLegs(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [hasSSLegs]: "+player.getInventory().getChestplate() != null
                && player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId));
        }
        return player.getInventory().getLeggings() != null
                && player.getInventory().getLeggings().getTypeId() == plugin.getConfig().getInt(SSConfig.legsId);

    }

    public static boolean hasSSBoots(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [hasSSBoots]: "+player.getInventory().getChestplate() != null
                && player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId));
        }
        return player.getInventory().getBoots() != null
                && player.getInventory().getBoots().getTypeId() == plugin.getConfig().getInt(SSConfig.bootsId);
    }

    public static boolean hasSSSword(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [hasSSSword]: "+player.getInventory().getChestplate() != null
                && player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId));
        }
        return player.getInventory().getItemInHand() != null
                && player.getInventory().getItemInHand().getTypeId() == plugin.getConfig().getInt(SSConfig.swordId);
    }

    public static boolean hasSSAxe(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [hasSSAxe]: "+player.getInventory().getChestplate() != null
                && player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId));
        }
        return player.getInventory().getItemInHand() != null
                && player.getInventory().getItemInHand().getTypeId() == plugin.getConfig().getInt(SSConfig.axeId);
    }
    public static boolean hasSSPick(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [hasSSPick]: "+player.getInventory().getChestplate() != null
                && player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId));
        }
        return player.getInventory().getItemInHand() != null
                && player.getInventory().getItemInHand().getTypeId() == plugin.getConfig().getInt(SSConfig.pickId);
    }
    public static boolean hasSSShovel(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player pass check [hasSSShovel]: "+player.getInventory().getChestplate() != null
                && player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId));
        }
        return player.getInventory().getItemInHand() != null
                && player.getInventory().getItemInHand().getTypeId() == plugin.getConfig().getInt(SSConfig.shovelId);
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
        return player.getInventory().getItemInHand().getTypeId();
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
