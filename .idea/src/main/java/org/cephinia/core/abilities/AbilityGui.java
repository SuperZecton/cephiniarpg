package org.cephinia.core.abilities;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.cephinia.core.utils.ItemBuilder;
import org.cephinia.core.utils.Utils;

public class AbilityGui {

    public static Inventory inv;
    public static String inventory_name;
    public static int inv_rows = 9;

    public static void initialize() {
        inventory_name = Utils.chat("&c&lMagical Book");
        inv = Bukkit.createInventory(null, inv_rows);
    }


    public static Inventory GUI (Player player) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);
        toReturn.setItem(0, ItemBuilder.start(Material.FIREBALL).name("&cFireball").lore("&b Costs 1 Mana", "&a Magical Skill").build());
        toReturn.setItem(1, ItemBuilder.start(Material.GHAST_TEAR).name("&cDragonVortex").lore("&b Costs 1 Mana", "&a Magical Skill").build());
        toReturn.setItem(8, ItemBuilder.start(Material.EYE_OF_ENDER).name("&cTeleport").lore("&b Costs 1 Mana", "&a Magical Skill").build());

        for(int slots = 0; slots < inv.getSize();  slots++) {
            if(inv.getItem(slots) == null) {
                inv.setItem(slots, ItemBuilder.start(Material.STAINED_GLASS_PANE).data((short) 14).name("").lore("").build());

            }

        }


        toReturn.setContents(inv.getContents());
        return toReturn;

    }

    public static void clicked(Player player, int slot, ItemStack clicked, Inventory inv) {
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&cFireball"))) {

            fireballSkill.doThrow(player.launchProjectile(Fireball.class), true, 3);
        }

        else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&cDragonVortex"))){
            player.sendMessage(Utils.chat("&aThis will be added in later"));


        }

        else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&cTeleport"))){
            Location playerLocation = player.getLocation();
            Vector playerDirection = player.getLocation().getDirection();
            playerDirection.multiply(3);
            Location targetLocation = playerLocation.add(playerDirection);


            teleportToLocation(player, targetLocation);


        }




    }



    private static void teleportToLocation(Player player, Location location){
        player.teleport(location);


    }

}
