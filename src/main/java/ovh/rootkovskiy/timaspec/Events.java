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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Events implements Listener {

    @EventHandler
    public void command(PlayerCommandPreprocessEvent event) {

        Player checkedPlayer = event.getPlayer();

        if (Main.getCacheManager().inspec.contains(checkedPlayer.getUniqueId())) {
            if (!(event.getMessage().equals("/exitspec"))) {
                checkedPlayer.sendMessage(Main.getCacheManager().cannotsend);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void message(AsyncPlayerChatEvent event) {

        Player checkedPlayer = event.getPlayer();

        if (Main.getCacheManager().inspec.contains(checkedPlayer.getUniqueId())) {
            if (!(event.getMessage().equals("/exitspec"))) {
                checkedPlayer.sendMessage(Main.getCacheManager().cannotsend);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void move(PlayerMoveEvent event) {

        if (Main.getCacheManager().radius_enable) {

            Player checkedPlayer = event.getPlayer();

            if (Main.getCacheManager().inspec.contains(checkedPlayer.getUniqueId())) {
                UUID targetUUID = Main.getCacheManager().targetSystem.get(checkedPlayer.getUniqueId());
                Player target = Bukkit.getPlayer(targetUUID);

                List<Player> nearbytarget = new ArrayList<>();
                for (Entity entity : target.getNearbyEntities(Main.getCacheManager().radius_value, Main.getCacheManager().radius_value, Main.getCacheManager().radius_value)) {
                    if (entity.getType() == EntityType.PLAYER) {
                        nearbytarget.add(((Player) entity));
                    }
                }

                if (!(nearbytarget.contains(checkedPlayer))) {
                    checkedPlayer.teleport(target);
                    checkedPlayer.sendMessage(Main.getCacheManager().radius_message);
                }
            }
        }
    }
}
