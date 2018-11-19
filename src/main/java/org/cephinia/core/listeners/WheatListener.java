package org.cephinia.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.cephinia.core.Main;



public class WheatListener implements Listener {

    public int multipler = 2;

    private Main plugin;
    public WheatListener(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Block block = e.getBlock();

        Bukkit.getLogger().info("1");
        if(block.getType().equals(Material.CROPS)){
            Bukkit.getLogger().info("2");
            ItemStack item = new ItemStack(Material.WHEAT, multipler);
            Bukkit.getLogger().info("3");
            Player p = e.getPlayer();
            Bukkit.getLogger().info("4");
            e.setCancelled(true);
            Bukkit.getLogger().info("5");
            block.setType(Material.SEEDS);
            p.getInventory().addItem(item);


        }


    }

}
