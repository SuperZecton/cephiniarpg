package org.cephinia.core.events;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import org.cephinia.core.Main;
import org.cephinia.core.utils.Utils;

public class ItemDropListener implements Listener{

    private Main plugin;
    public ItemDropListener (Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);


    }


    @EventHandler(ignoreCancelled=true)

    public void onDrop(PlayerDropItemEvent e){
        if(e.getItemDrop().getItemStack().getType() == Material.BOOK && e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.output("&eMagical Book"))){

            e.setCancelled(true);
        }





    }

}
