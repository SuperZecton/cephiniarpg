package org.cephinia.core;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.cephinia.core.abilities.AbilityGui;
import org.cephinia.core.commands.HealCommand;
import org.cephinia.core.events.*;
import org.cephinia.core.skills.WheatListener;
import org.cephinia.core.utils.Utils;

public class Main extends JavaPlugin {


    public ItemStack getMagicalBook(){
        ItemStack magicalBook = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = magicalBook.getItemMeta();
        meta.setDisplayName(Utils.output("&eMagical Book"));
        magicalBook.setItemMeta(meta);

        return magicalBook;
    }

    @Override
    public void onEnable(){
        new WheatListener(this);
        new JoinListener(this);
        new MenuListen(this);
        new InventoryClickListener(this);
        new ItemDropListener(this);
        new PlayerDeathListener(this);
        new HealCommand(this);
        AbilityGui.initialize();
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "CephiniaCore is starting!" );

    }

}
