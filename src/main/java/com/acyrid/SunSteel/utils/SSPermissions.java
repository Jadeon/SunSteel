package com.acyrid.SunSteel.utils;
//Permissions Layer
import org.bukkit.entity.Player;
public class SSPermissions{

    private static final String chestPerm = "sunsteel.armor.chest";
    private static final String bootsPerm = "sunsteel.armor.boots";
    private static final String helmsPerm = "sunsteel.armor.helm";
    private static final String pantsPerm = "sunsteel.armor.legs";
    private static final String hoverLavaPerm = "sunsteel.special.lavafloat";
    private static final String hoverWaterPerm = "sunsteel.special.waterfloat";
    private static final String breatheWaterPerm = "sunsteel.special.waterbreath";
    private static final String fireResistPerm = "sunsteel.special.fireresist";
    private static final String fireRipostePerm = "sunsteel.special.fireriposte";
    private static final String fallDamagePerm = "sunsteel.special.safefall";
    private static final String swordPerm = "sunsteel.tools.sword";
    private static final String axePerm = "sunsteel.tools.axe";
    private static final String pickPerm = "sunsteel.tools.pick";
    private static final String shovelPerm = "sunsteel.tools.shovel";

    public static boolean allowedChest(Player player){return player.hasPermission(chestPerm);}

    public static boolean allowedPants(Player player){return player.hasPermission(pantsPerm);}

    public static boolean allowedHelm(Player player){return player.hasPermission(helmsPerm);}

    public static boolean allowedBoots(Player player){return player.hasPermission(bootsPerm);}

    public static boolean allowedLavaHover(Player player){return player.hasPermission(hoverLavaPerm);}

    public static boolean allowedWaterHover(Player player){return player.hasPermission(hoverWaterPerm);}

    public static boolean allowedWaterBreath(Player player){return player.hasPermission(breatheWaterPerm);}

    public static boolean allowedFireResist(Player player){return player.hasPermission(fireResistPerm);}

    public static boolean allowedFireRiposte(Player player){return player.hasPermission(fireRipostePerm);}

    public static boolean allowedFallDamage(Player player){return player.hasPermission(fallDamagePerm);}

    public static boolean allowedSword(Player player){return player.hasPermission(swordPerm);}

    public static boolean allowedAxe(Player player){return player.hasPermission(axePerm);}

    public static boolean allowedPick(Player player){return player.hasPermission(pickPerm);}

    public static boolean allowedShovel(Player player){return player.hasPermission(shovelPerm);}

}


