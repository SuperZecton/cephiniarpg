package org.cephinia.core.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import org.cephinia.core.Main;
import org.cephinia.core.utils.Utils;
public class JoinListener implements Listener {
    Main main = new Main();




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
        ItemStack item = main.getMagicalBook();

        if(p.getInventory().contains(item)) {

            return;

        }
        else {

            p.getInventory().addItem(item);



        }

    }
}
