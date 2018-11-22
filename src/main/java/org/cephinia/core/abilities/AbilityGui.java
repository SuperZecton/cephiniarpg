package org.cephinia.core.abilities;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.cephinia.core.utils.InventoryBuilder;
import org.cephinia.core.utils.Utils;

public class AbilityGui {

    public static Inventory inv;
    public static String inventory_name;
    public static int inv_rows = 1 * 9;

    public static void initialize() {
        inventory_name = Utils.chat("&c&lMagical Book");
        inv = Bukkit.createInventory(null, inv_rows);
    }


    public static Inventory GUI (Player player) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        InventoryBuilder.createItem(inv, 385, 1, 0, "&cFireball", "&b Costs 1 Mana", "&a Magical Skill");
        InventoryBuilder.createItem(inv, 370, 1, 1, "&cDragonVortex", "&b Costs 3 Mana", "&a Magical Skill");
        InventoryBuilder.createItem(inv, 381, 1, 8, "&cTeleport", "&b Costs 1 Mana", "&a Magical Skill");

        for(int slots = 0; slots < inv.getSize();  slots++) {
            if(inv.getItem(slots) == null) {
                InventoryBuilder.createItemByte(inv, 160, 14,1, slots, " ", " ");


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
