package org.cephinia.core.modules.farming;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;
import org.cephinia.core.Main;



public class WheatListener implements Listener {

    public int multipler = 2;
    ItemStack wheatDrops = new ItemStack(Material.WHEAT, multipler);
    ItemStack seeds = new ItemStack(Material.SEEDS, multipler);

    private Main plugin;
    public WheatListener(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Block block = event.getBlock();

        if(block.getType().equals(Material.CROPS) && block.getData() == (byte) 7)  {

                event.setCancelled(true);
                //Cancels usual event
                Player player = event.getPlayer();
                player.getInventory().addItem(wheatDrops, seeds);

                block.setType(Material.AIR);
                //Makes it AIR

                if(player.getInventory().contains(Material.SEEDS)){

                    player.getInventory().removeItem(new ItemStack(Material.SEEDS, 1));
                    //removes seeds from player inv
                    block.setType(Material.CROPS);
                    //Replaces AIR with Seed CROPS

                }

                else{
                    player.sendMessage("You do not have enough seeds to replant automatically");


                }

            }


        }






    }


