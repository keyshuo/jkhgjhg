package com.keyshuo.myfirstplugin;

import com.sheepion.custompotionapi.CustomPotionManager;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin implements Listener {
    private static JavaPlugin plugin;

    public static JavaPlugin getInstance() {
        return plugin;
    }

    public MyFirstPlugin() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        // Plugin startup logic
        CustomPotionManager.registerPotionEffectType(new MyPotionType());
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player=event.getPlayer();
        player.getInventory().setItemInMainHand(CustomPotionManager.getPotion (new NamespacedKey(MyFirstPlugin.getInstance(),"my_potion"),200,1,10));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
