package ovh.rootkovskiy.timaspec;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import ovh.rootkovskiy.timaspec.cache.CacheManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Events implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {

        Player checkedPlayer = event.getPlayer();

        if (CacheManager.inspec.contains(checkedPlayer.getUniqueId())) {
            if (!(event.getMessage().equals("/exitspec"))) {
                checkedPlayer.sendMessage(CacheManager.cannotsend);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {

        Player checkedPlayer = event.getPlayer();

        if (CacheManager.inspec.contains(checkedPlayer.getUniqueId())) {
            if (!(event.getMessage().equals("/exitspec"))) {
                checkedPlayer.sendMessage(CacheManager.cannotsend);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        if (CacheManager.radius_enable) {

            Player checkedPlayer = event.getPlayer();

            if (CacheManager.inspec.contains(checkedPlayer.getUniqueId())) {
                UUID targetUUID = CacheManager.targetSystem.get(checkedPlayer.getUniqueId());
                Player target = Bukkit.getPlayer(targetUUID);

                List<Player> nearbytarget = new ArrayList<>();
                for (Entity entity : target.getNearbyEntities(CacheManager.radius_value, CacheManager.radius_value, CacheManager.radius_value)) {
                    if (entity.getType() == EntityType.PLAYER) {
                        nearbytarget.add(((Player) entity));
                    }
                }

                if (!(nearbytarget.contains(checkedPlayer))) {
                    checkedPlayer.teleport(target);
                    checkedPlayer.sendMessage(CacheManager.radius_message);
                }
            }
        }
    }
}
