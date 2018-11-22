package org.cephinia.core.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


import org.cephinia.core.Main;

public class JoinListener implements Listener {


    private Main plugin;
    public JoinListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);


    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        //Makes the Item Book of Wisdom

        //Defines Player
        Player p = e.getPlayer();
        ItemStack item = plugin.getMagicalBook();

        if(p.getInventory().contains(item)) {

            return;

        }
        else {

            p.getInventory().addItem(item);



        }

    }
}
