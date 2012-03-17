package com.acyrid.SunSteel;

import com.acyrid.SunSteel.listeners.*;
import com.acyrid.SunSteel.utils.SSMechanics;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class SunSteel extends JavaPlugin{

    private SSPlayerListener playerListener = new SSPlayerListener(this);
    private SSDamageListener damageListener = new SSDamageListener(this);
    private SSBlockListener blockListener = new SSBlockListener(this);
    private SSEntityListener entityListener = new SSEntityListener(this);

    public void onDisable(){
        System.out.println("["+getName()+"] disabled..");
    }                                                    
    public void onEnable(){
        if(!new File(this.getDataFolder(), "config.yml").exists()){
            saveDefaultConfig();
        }
        getConfig();
        this.registerEvents();
        SSMechanics.init(this);
        System.out.println("[" + getName() + "] enabled!");
        getConfig().getKeys(true);
        System.out.println(getConfig().getKeys(true));
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.playerListener, this);
        pm.registerEvents(this.blockListener, this);
        pm.registerEvents(this.damageListener, this);
        pm.registerEvents(this.entityListener, this);

    }


}
