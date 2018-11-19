package org.cephinia.core;


import org.bukkit.plugin.java.JavaPlugin;
import org.cephinia.core.modules.farming.WheatListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        new WheatListener(this);


    }

}
