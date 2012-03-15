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
        return player.getInventory().getHelmet().getTypeId() == plugin.getConfig().getInt(SSConfig.helmId);
    }

    public static boolean hasSSChest(Player player){
        return player.getInventory().getChestplate().getTypeId() == plugin.getConfig().getInt(SSConfig.chestId);
    }

    public static boolean hasSSLegs(Player player){
        return player.getInventory().getLeggings().getTypeId() == plugin.getConfig().getInt(SSConfig.legsId);
    }

    public static boolean hasSSBoots(Player player){
        return player.getInventory().getBoots().getTypeId() == plugin.getConfig().getInt(SSConfig.bootsId);
    }

    public static boolean hasSSSword(Player player){
        return player.getInventory().getItemInHand().getTypeId() == plugin.getConfig().getInt(SSConfig.swordId);
    }

    public static boolean hasSSAxe(Player player){
        return player.getInventory().getItemInHand().getTypeId() == plugin.getConfig().getInt(SSConfig.axeId);
    }
    public static boolean hasSSPick(Player player){
        return player.getInventory().getItemInHand().getTypeId() == plugin.getConfig().getInt(SSConfig.pickId);
    }
    public static boolean hasSSShovel(Player player){
        return player.getInventory().getItemInHand().getTypeId() == plugin.getConfig().getInt(SSConfig.shovelId);
    }

    public static boolean hasSSWeapon(Player player){
        return (hasSSSword(player) && SSPermissions.allowedSword(player))|| (hasSSAxe(player) && SSPermissions.allowedAxe(player));
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
        return (getHitChance() >= luck);
    }

    public static int getHitChance(){
        return plugin.getConfig().getInt(SSConfig.hitChance);
    }
    public static boolean smeltChance() {
        double luck =  Math.random()*100;
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
    

}
