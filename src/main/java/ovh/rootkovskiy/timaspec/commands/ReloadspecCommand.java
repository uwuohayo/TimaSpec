package ovh.rootkovskiy.timaspec.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ovh.rootkovskiy.timaspec.Main;

public class ReloadspecCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        //command reloadspec

        if (!sender.hasPermission("timaspec.reloadspec")) {
            sender.sendMessage(Main.getCacheManager().noperm);
            return true;
        }

        if (args.length != 0) {
            sender.sendMessage(Main.getCacheManager().usagereload);
            return true;
        }

        Main.getCacheManager().loadArrays();
        sender.sendMessage(Main.getCacheManager().successreload);
        return true;
    }
}
