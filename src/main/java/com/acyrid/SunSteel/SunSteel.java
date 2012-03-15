package com.acyrid.SunSteel;

import com.acyrid.SunSteel.listeners.*;
import com.acyrid.SunSteel.utils.SSMechanics;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;


import java.io.File;

public class SunSteel extends JavaPlugin{
    //Permission Handler
    //private SSPermissions ph;
    //Listeners
    private SSPlayerListener playerListener = new SSPlayerListener(this);
    private SSDamageListener damageListener = new SSDamageListener(this);
    private SSBlockListener blockListener = new SSBlockListener(this);
    private SSEntityListener entityListener = new SSEntityListener(this);

    File configFile = new File("plugins/SunSteel/config.yml");
    FileConfiguration config;
    
    public void onDisable(){
        System.out.println("["+getName()+"] disabled..");
    }                                                    
    public void onEnable(){
        if(!this.configFile.exists()){
            saveDefaultConfig();
        }
        this.config = getConfig();
        this.registerEvents();
        SSMechanics.init(this);
        System.out.println("[" + getName() + "] enabled!");
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.playerListener, this);
        pm.registerEvents(this.blockListener, this);
        pm.registerEvents(this.damageListener, this);
        pm.registerEvents(this.entityListener, this);

    }


}
