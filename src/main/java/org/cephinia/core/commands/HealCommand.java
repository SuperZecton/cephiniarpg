package org.cephinia.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cephinia.core.Main;

public class HealCommand implements CommandExecutor {

    private Main plugin;
    public HealCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("heal").setExecutor(this);

    }



    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Consoles can't be healed");
            return true;
        }
        Player targetPlayer = (Player) commandSender;
        Double MaxHealth = targetPlayer.getMaxHealth();
        targetPlayer.setHealth(MaxHealth);
        targetPlayer.setFoodLevel(20);
        targetPlayer.setFireTicks(0);



        return false;
    }
}
