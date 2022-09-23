package ovh.rootkovskiy.timaspec.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ovh.rootkovskiy.timaspec.Main;

public class ExitspecCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        //command exitspec

        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.getCacheManager().notplayer);
            return true;
        }

        if (!sender.hasPermission("timaspec.exitspec")) {
            sender.sendMessage(Main.getCacheManager().noperm);
            return true;
        }

        if (args.length != 0) {
            sender.sendMessage(Main.getCacheManager().usageexit);
            return true;
        }

        if (!(Main.getCacheManager().inspec.contains(p.getUniqueId()))) {
            sender.sendMessage(Main.getCacheManager().exitspecnonspec);
            return true;
        }

        Main.getCacheManager().inspec.remove(p.getUniqueId());
        Main.getCacheManager().targetSystem.remove(p.getUniqueId());
        p.teleport(Main.getCacheManager().spawnlocation);
        p.setGameMode(GameMode.SURVIVAL);
        p.sendMessage(Main.getCacheManager().messageoutspec);
        return true;
    }
}
