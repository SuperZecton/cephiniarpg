package org.cephinia.core.utils;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryBuilder {


    public static ItemStack createItem(Inventory inv, int materialId, int amount, int invSlot, String displayName, String... loreString) {
        ItemStack item;
        List<String> lore = new ArrayList();

        item = new ItemStack(Material.getMaterial(materialId), amount);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for (String s : loreString)
        {
            lore.add(Utils.chat(s));

        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot , item);


        return item;

    }



    public static ItemStack createItemByte(Inventory inv, int materialId, int byteId, int amount, int invSlot, String displayName, String... loreString) {
        ItemStack item;
        List<String> lore = new ArrayList();

        item = new ItemStack(Material.getMaterial(materialId), amount, (short) byteId);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for (String s : loreString)
        {
            lore.add(Utils.chat(s));

        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot , item);


        return item;

    }
}
