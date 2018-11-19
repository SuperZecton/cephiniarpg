package org.cephinia.core;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.cephinia.core.listeners.*;
import org.cephinia.core.modules.SkillGui;
import org.cephinia.core.modules.farming.WheatListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        new WheatListener(this);
        new JoinListener(this);
        new MenuListen(this);
        new InventoryClickListener(this);
        new ItemDropListener(this);
        new PlayerDeathListener(this);
        SkillGui.initialize();
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "CephiniaCore is starting!" );

    }

}
