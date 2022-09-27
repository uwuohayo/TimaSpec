package ovh.rootkovskiy.timaspec.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ovh.rootkovskiy.timaspec.cache.CacheManager;

public class ExitspecCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        //command exitspec

        if (!(sender instanceof Player)) {
            sender.sendMessage(CacheManager.notplayer);
            return true;
        }

        if (!sender.hasPermission("timaspec.exitspec")) {
            sender.sendMessage(CacheManager.noperm);
            return true;
        }

        if (args.length != 0) {
            sender.sendMessage(CacheManager.usageexit);
            return true;
        }

        if (!(CacheManager.inspec.contains(p.getUniqueId()))) {
            sender.sendMessage(CacheManager.exitspecnonspec);
            return true;
        }

        CacheManager.abstractBossBar.removePlayer(p);
        CacheManager.inspec.remove(p.getUniqueId());
        CacheManager.targetSystem.remove(p.getUniqueId());
        p.teleport(CacheManager.spawnlocation);
        p.setGameMode(CacheManager.gamemode_exitspec);
        p.sendMessage(CacheManager.messageoutspec);
        return true;
    }
}
