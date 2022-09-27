package ovh.rootkovskiy.timaspec.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ovh.rootkovskiy.timaspec.cache.CacheManager;

public class ReloadspecCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        //command reloadspec

        if (!sender.hasPermission("timaspec.reloadspec")) {
            sender.sendMessage(CacheManager.noperm);
            return true;
        }

        if (args.length != 0) {
            sender.sendMessage(CacheManager.usagereload);
            return true;
        }

        CacheManager.loadArrays();
        sender.sendMessage(CacheManager.successreload);
        return true;
    }
}
