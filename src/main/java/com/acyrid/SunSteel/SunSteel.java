package com.acyrid.SunSteel;

import com.acyrid.SunSteel.listeners.*;
import com.acyrid.SunSteel.utils.SSConfig;
import com.acyrid.SunSteel.utils.SSMechanics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.util.logging.Level;

import static java.nio.file.Files.delete;
import static java.nio.file.Files.deleteIfExists;

public class SunSteel extends JavaPlugin{

    private SSPlayerListener playerListener = new SSPlayerListener(this);
    private SSDamageListener damageListener = new SSDamageListener(this);
    private SSBlockListener blockListener = new SSBlockListener(this);
    private SSEntityListener entityListener = new SSEntityListener(this);
    private String configVersion = "1.02h";
    private String oldconfigVersion = "1.02f";

    public void onDisable(){
        this.getLogger().log(Level.INFO, "is Disabled!");
    }                                                    
    public void onEnable(){
        if(!new File(this.getDataFolder(), "config.yml").exists()){
            this.getLogger().log(Level.INFO, "<----FIRST RUN, Generating config.yml---->");
            saveDefaultConfig();
        }else if(!this.getConfig().getString(SSConfig.configCheck).contentEquals(configVersion)){
            File file = new File(this.getDataFolder()+File.separator+"config.yml");
            this.getLogger().log(Level.INFO, "<----Config.yml is not up-to-date for this version---->");
            file.renameTo(new File(this.getDataFolder()+File.separator + "OLD_config_" + oldconfigVersion + ".yml"));
            this.getLogger().log(Level.INFO, "<----Renaming your Config to OLD_config_" + oldconfigVersion + ".yml---->");
            this.getLogger().log(Level.INFO, "<----Generating new config.yml for version:"+configVersion+"----->");
            saveDefaultConfig();
            this.getLogger().log(Level.INFO, "A new config file has been created please make adjustments as needed.");
        }
        getConfig();
        this.registerEvents();
        SSMechanics.init(this);
        this.getLogger().log(Level.INFO, "is now enabled with more solar flares then ever!");
        if(!SSMechanics.getNoCheatInstalled()){
        this.getLogger().log(Level.INFO, "No Anti-Cheats set in config, Play-Nice mode inactive.");
        }else{this.getLogger().log(Level.INFO, "Anti-Cheat settings detected. Play-Nice mode ENFORCED.");}
        getConfig().getKeys(true);
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.playerListener, this);
        pm.registerEvents(this.blockListener, this);
        pm.registerEvents(this.damageListener, this);
        pm.registerEvents(this.entityListener, this);

    }


}
