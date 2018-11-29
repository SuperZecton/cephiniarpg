package org.cephinia.core.events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class PlayerChatListener implements Listener {

    public void onPlayerChat(AsyncPlayerChatEvent e){
        String message = e.getMessage();



    }
}
