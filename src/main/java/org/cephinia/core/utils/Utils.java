package org.cephinia.core.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Utils {
    // Debug mode, displays errors in console when enabled
    private static boolean debugMode = false;

    /**
     * Returns a colour formatted string
     *
     * @param s String of text
     * @return The formatted string
     */
    public static String output(String s) {
        // Return a string with colour codes formated
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    /**
     * Prints a message directly to the console with the plugin name
     *
     * @param s The message
     */
    public static void cout(String s) {
        // Send a message to the console along with the custom plugin name (so you know which plugin is doing what)
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&9LavRPG&8]&6:> " + s));
    }

    /**
     * Gets the UUID of a player in string
     *
     * @param player The player
     * @return The UUID
     */
    public static String getUUID(Player player) {
        // Return the UUID of this player
        return player.getUniqueId().toString();
    }

    /**
     * Gets the name of the player from the UUID in string
     *
     * @param playerUUID
     * @return
     */
    public static String getPlayerFromUUID(String playerUUID) {
        // Return the name of the player from the UUID
        return Bukkit.getPlayer(UUID.fromString(playerUUID)).getName();
    }

    /**
     * Writes data in CSV format to an area based on the directory,
     * the folder the file is in, the filename itself and the type of data
     *
     * @param directory The full path location of the file
     * @param folder    The folder the file inside
     * @param file      The filename itself
     * @param data      The type of data being inputed <b>(an Array or ArrayList only)
     * @return If writing to the file was successful
     */
    public static boolean writeToFile(File directory, File folder, File file, Object data) {
        // What type of array is it
        boolean isArray;

        // Check if the directory requested already exists
        if (!directory.exists()) {
            // If it doesn't create the directory and the folders
            try {
                // Create directory
                folder.mkdirs();

                // Create new file
                file.createNewFile();
            } catch (IOException e1) {
                Utils.cout("&4Directory creation operation failed!");
                e1.printStackTrace();
            }
        }

        // Check the type of the array
        isArray = getArrayType(data);

        // Check again to see if the directory exists
        if (directory.exists()) {
            // If it does exist, create a buffered writer and write
            try {
                // Create buffered writer
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                // If the data is held in a regular array
                if (isArray) {
                    // Cast object to a string array
                    String[] newData = (String[]) data;

                    // For each line of data...
                    for (int i = 0; i < newData.length; i++) {
                        // Write the data and return a new line
                        bw.write(newData[i]);
                        bw.newLine();
                    }
                }
                // If the data is held in an array list
                else {
                    // Cast object to a string array list
                    @SuppressWarnings("unchecked")
                    ArrayList<String> newData = (ArrayList<String>) data;

                    // For each line of data...
                    for (int i = 0; i < newData.size(); i++) {
                        // Write the data and return a new line
                        bw.write(newData.get(i));
                        bw.newLine();
                    }
                }

                // Close the buffer writer and return true
                bw.close();
                return true;
            } catch (Exception e1) {
                // If an IOException occurred and something went wrong
                Utils.cout("&4File write operation failed!");
                Utils.handleException(e1);
            }
        } else {
            // If the previous action of creating a directory failed we have a problem...
            Utils.cout("&4Previous directory creation operation failed!");
        }

        // If code gets to here, the writer failed
        return false;
    }

    /**
     * Reads data from a file and returns the data in
     * the form of a string array list
     *
     * @param directory The path to the file to read from
     * @return An array list of data
     */
    public static ArrayList<String> readFromFile(File directory) {
        // Create a blank data array list
        ArrayList<String> data = new ArrayList<String>();

        // Check the directory exists
        if (!directory.exists()) {
            // If the directory exists, create a buffered reader and read
            try {
                // Create a buffered reader and read
                BufferedReader br = new BufferedReader(new FileReader(directory));
                String line = br.readLine();

                // While there is still data to be read from the file, add it to the array list
                while (line != null) {
                    // Add newly read line from file to the array list
                    data.add(line);
                }

                // Close the buffered reader
                br.close();
            } catch (IOException e) {
                // If an IOException and something went wrong
                Utils.cout("&4Directory read operation failed!");
                e.printStackTrace();
            }
        } else {
            // When you are trying to read a file that doesn't exist
            Utils.cout("&4Directory does not exist!");
        }

        // Return the data
        return data;
    }

    /**
     * Gets the type of array that the data is being held in
     *
     * @param obj The array
     * @return If the array is a regular one or an array list
     */
    public static boolean getArrayType(Object obj) {
        // Return true if regular array, otherwise return false for array list
        return obj != null && obj.getClass().isArray();
    }

    /**
     * Gathers a list of currently online players to check if
     * the player passed is online
     *
     * @param player The player to check if it is online
     * @return True or False if the player is online
     */
    public static boolean isOnline(Player player) {
        // Get the display name of the requested player
        String name = player.getDisplayName();

        // For each player on the server compare their name to the requested players name
        for (Player p : Bukkit.getOnlinePlayers()) {
            // If a players name on the server is equal to the requested players name
            if (p.getName().equalsIgnoreCase(name)) {
                // Player is online
                return true;
            }
        }

        // Player is offline
        return false;
    }

    /**
     * Gets a player from their display name
     *
     * @param name The display name of the player
     * @return The player
     */
    public static Player getPlayerFromName(String name) {
        // Gets the player from the display name
        Player p = Bukkit.getPlayer(name);

        // Returns the player
        return p;
    }

    /**
     * Toggles debug mode to tell the plugin to print
     * out handled exceptions or not
     */
    public static void toggleDebugMode() {
        // If the plugin is in debug mode
        if (debugMode) {
            // Turn debug mode off
            debugMode = false;
        } else {
            // Turn debug mode on
            debugMode = true;
        }
    }

    /**
     * Gets the current state of debug
     *
     * @return If the plugin is in debug mode
     */
    public static boolean getDebugMode() {
        // Get current state of debug
        return debugMode;
    }

    /**
     * Handles all exceptions from all try catches in the
     * plugin and will print them out when in debug mode
     *
     * @param e The exception
     */
    public static void handleException(Exception e) {
        // If the plugin is in debug mode
        if (debugMode) {
            // Print the exception to the console
            e.printStackTrace();
        }
    }

    /**
     * Sends a common error message to the player when a
     * command failed to execute correctly
     *
     * @return An error message string
     */
    public static String sendPlayerError() {
        // Return an error message stating something went wrong
        return "&cSomething in the plugin just broke! Did you enter the arguments correctly?";
    }
}
