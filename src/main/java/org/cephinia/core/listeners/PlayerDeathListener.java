package org.cephinia.core.listeners;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import org.cephinia.core.Main;
import org.cephinia.core.utils.Utils;

public class PlayerDeathListener implements Listener{

    private Main plugin;
    public PlayerDeathListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);


    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat("&eMagical Book"));
        item.setItemMeta(meta);

        e.getDrops().remove(item);




    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat("&eMagical Book"));
        item.setItemMeta(meta);

        Player p = e.getPlayer();

        if(p.getInventory().contains(item)) {
            return;

        } else {
            p.getInventory().addItem(item);
        }


    }

}
