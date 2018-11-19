package org.cephinia.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.cephinia.core.Main;
import org.cephinia.core.modules.SkillGui;

public class InventoryClickListener implements Listener{

    private Main plugin;
    public InventoryClickListener(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getInventory().getTitle();
        if (title.equals(SkillGui.inventory_name)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.getMaterial("RED_STAINED_GLASS_PANE")) {
                return;
            }

            if(title.equals(SkillGui.inventory_name)) {
                SkillGui.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        }

    }
}
