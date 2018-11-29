package org.cephinia.core.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.cephinia.core.Main;
import org.cephinia.core.abilities.AbilityGui;

public class InventoryClickListener implements Listener{



    private Main plugin;
    public InventoryClickListener(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getInventory().getTitle();
        if (title.equals(AbilityGui.inventory_name)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.getMaterial("RED_STAINED_GLASS_PANE")) {
                return;
            }

            if(title.equals(AbilityGui.inventory_name)) {
                AbilityGui.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        }

    }
}
