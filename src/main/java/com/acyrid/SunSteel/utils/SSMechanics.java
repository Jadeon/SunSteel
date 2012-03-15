package com.acyrid.SunSteel.utils;


import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by IntelliJ IDEA.
 * User: JD
 * Date: 3/14/12
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class SSMechanics {
    public static boolean hasSSArmor(Player player){
        return (hasSSChest(player) && SSPermissions.allowedChest(player))
                && (hasSSLegs(player) && SSPermissions.allowedPants(player))
                && (hasSSHelm(player) && SSPermissions.allowedHelm(player))
                && (hasSSBoots(player)&& SSPermissions.allowedBoots(player));
    }
    public static boolean hasSSHelm(Player player){
        return player.getInventory().getHelmet().getTypeId() == SSConfig.helmId;
    }

    public static boolean hasSSChest(Player player){
        return player.getInventory().getChestplate().getTypeId() == SSConfig.chestId;
    }

    public static boolean hasSSLegs(Player player){
        return player.getInventory().getLeggings().getTypeId() == SSConfig.legsId;
    }

    public static boolean hasSSBoots(Player player){
        return player.getInventory().getBoots().getTypeId() == SSConfig.bootsId;
    }

    public static boolean hasSSSword(Player player){
        return player.getInventory().getItemInHand().getTypeId() == SSConfig.swordId;
    }

    public static boolean hasSSAxe(Player player){
        return player.getInventory().getItemInHand().getTypeId() == SSConfig.axeId;
    }
    public static boolean hasSSPick(Player player){
        return player.getInventory().getItemInHand().getTypeId() == SSConfig.pickId;
    }
    public static boolean hasSSShovel(Player player){
        return player.getInventory().getItemInHand().getTypeId() == SSConfig.shovelId;
    }

    public static boolean hasSSWeapon(Player player){
        return (hasSSSword(player) && SSPermissions.allowedSword(player))|| (hasSSAxe(player) && SSPermissions.allowedAxe(player));
    }
    
    public static boolean hasSSHover(Player player){
        return (hasSSBoots(player) && SSPermissions.allowedBoots(player) && SSPermissions.allowedHover(player));
    }
    
    public static int getHeldItem(Player player){
        return player.getInventory().getItemInHand().getTypeId();
    }
    public static boolean hitChance() {
        double luck =  Math.random()*100;
        return (getHitChance() >= luck);
    }

    public static int getHitChance(){
        return SSConfig.hitChance;
    }
    public static boolean smeltChance() {
        double luck =  Math.random()*100;
        return (getSmeltChance() >= luck);
    }

    public static int getSmeltChance(){
        return SSConfig.smeltChance;
    }
    public static int getFireTicks(){
        return SSConfig.fireDuration;
    }
    
    public static boolean getFireRiposte(){
        return SSConfig.fireRiposte;
    }
    
    public static boolean getFireResist(){
        return SSConfig.fireResist;
    }

    public static boolean getFireBreather(){
        return SSConfig.fireBreather;
    }

    public static boolean getLavaWalker(){
        return SSConfig.lavaWalker;
    }

    public static boolean getWaterWalker(){
        return SSConfig.waterWalker;
    }
}
