package org.cephinia.core.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private ItemStack stack;

    public ItemBuilder(ItemStack stack) {
        this.stack = stack;
    }

    public static ItemBuilder start(Material material) {
        return new ItemBuilder(new ItemStack(material));
    }


    public ItemBuilder name(String name) {
        ItemMeta stackMeta = stack.getItemMeta();
        stackMeta.setDisplayName(Utils.output(name));
        stack.setItemMeta(stackMeta);
        return this;
    }


    public ItemBuilder amount(int amount) {
        stack.setAmount(amount);
        return this;
    }


    public ItemBuilder lore(String... lore) {
        for (int i = 0; i < lore.length; i++) {
            lore[i] = Utils.output(lore[i]);
        }

        ItemMeta stackMeta = stack.getItemMeta();
        stackMeta.setLore(Arrays.asList(lore));
        stack.setItemMeta(stackMeta);
        return this;
    }


    public ItemBuilder lore(List<String> lore) {
        for (int i = 0; i < lore.size(); i++) {
            lore.set(i, Utils.output(lore.get(i)));
        }

        ItemMeta stackMeta = stack.getItemMeta();
        stackMeta.setLore(lore);
        stack.setItemMeta(stackMeta);
        return this;
    }


    public ItemBuilder data(Number data) {
        stack.setDurability(data.shortValue());
        return this;
    }

    public ItemBuilder durability(Number durability) {
        stack.setDurability(durability.shortValue());
        return this;
    }

    public ItemStack build() {
        return stack;
    }

}
