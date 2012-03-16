package com.acyrid.SunSteel.utils;

import com.acyrid.SunSteel.SunSteel;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public class SSPermissions{

    private static final String chestPerm = "sunsteel.armor.chest";
    private static final String bootsPerm = "sunsteel.armor.boots";
    private static final String helmsPerm = "sunsteel.armor.helm";
    private static final String pantsPerm = "sunsteel.armor.legs";
    private static final String hoverLavaPerm = "sunsteel.armor.special.lavafloat";
    private static final String hoverWaterPerm = "sunsteel.armor.special.waterfloat";
    //private static final String breatheLavaPerm = "sunsteel.armor.special.lavabreath";
    private static final String breatheWaterPerm = "sunsteel.armor.special.waterbreath";
    private static final String swordPerm = "sunsteel.tools.sword";
    private static final String axePerm = "sunsteel.tools.axe";
    private static final String pickPerm = "sunsteel.tools.pick";
    private static final String shovelPerm = "sunsteel.tools.shovel";
    private static final String adminPerm = "sunsteel.admins";


    public static boolean allowedChest(Player player){
        if(SSMechanics.getDebugMode()){
        System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [chestPerm]: "+player.hasPermission(chestPerm));
        }
        return player.hasPermission(chestPerm);
    }

    public static boolean allowedPants(Player player){
        if(SSMechanics.getDebugMode()){
        System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [pantsPerm]: "+player.hasPermission(pantsPerm));
        }
        return player.hasPermission(pantsPerm);
    }

    public static boolean allowedHelm(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [helmPerm]: "+player.hasPermission(helmsPerm));
        }
        return player.hasPermission(helmsPerm);
    }

    public static boolean allowedBoots(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [bootsPerm]: "+player.hasPermission(bootsPerm));
        }
        return player.hasPermission(bootsPerm);
    }

    public static boolean allowedLavaHover(Player player){
                if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [hoverLavaPerm]: "+player.hasPermission(hoverLavaPerm));
        }
        return player.hasPermission(hoverLavaPerm);
    }

    public static boolean allowedWaterHover(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [hoverWaterPerm]: "+player.hasPermission(hoverWaterPerm));
        }
        return player.hasPermission(hoverWaterPerm);
    }

   /* public static boolean allowedLavaBreath(Player player){
        return player.hasPermission(breatheLavaPerm);
    }*/

    public static boolean allowedWaterBreath(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [breatheWaterPerm]: "+player.hasPermission(breatheWaterPerm));
        }
        return player.hasPermission(breatheWaterPerm);
    }

    public static boolean allowedSword(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [swordPerm]: "+player.hasPermission(swordPerm));
        }
        return player.hasPermission(swordPerm);
    }

    public static boolean allowedAxe(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [axePerm]: "+player.hasPermission(axePerm));
        }
        return player.hasPermission(axePerm);
    }

    public static boolean allowedPick(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [pickPerm]: "+player.hasPermission(pickPerm));
        }
        return player.hasPermission(pickPerm);
    }

    public static boolean allowedShovel(Player player){
        if(SSMechanics.getDebugMode()){
            System.out.println("[SUNSTEEL-DEBUG] Checking does Player have perm [shovelPerm]: "+player.hasPermission(shovelPerm));
        }
        return player.hasPermission(shovelPerm);
    }

}


