package org.cephinia.core.events;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import org.cephinia.core.Main;
import org.cephinia.core.abilities.AbilityGui;
import org.cephinia.core.utils.Utils;

public class MenuListen implements Listener{

    private Main plugin;


    public MenuListen (Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        //Define Player
        Player p = e.getPlayer();
        //Define Item in the hand



        ItemStack iteminhand = p.getInventory().getItemInMainHand();


        if (p.getInventory().getItemInMainHand().getType() != Material.BOOK) return;


        if (!iteminhand.hasItemMeta()) return;


        if (!iteminhand.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&eMagical Book"))) return;


        if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {

            if(p.hasPermission("GuiManager.item.use")) {


                p.openInventory(AbilityGui.GUI(p));
            }
            else {
                p.sendMessage(Utils.chat("&4You do not have permission to use the book!"));
                return;
            }

        }

    }





}
