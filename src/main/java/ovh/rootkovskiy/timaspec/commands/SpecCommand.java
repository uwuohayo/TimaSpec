package ovh.rootkovskiy.timaspec.commands;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ovh.rootkovskiy.timaspec.cache.CacheManager;

public class SpecCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        //command spec

        if (!(sender instanceof Player)) {
            sender.sendMessage(CacheManager.notplayer);
            return true;
        }

        if (!sender.hasPermission("timaspec.spec")) {
            sender.sendMessage(CacheManager.noperm);
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(CacheManager.usage);
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null || !target.isOnline()) {
            sender.sendMessage(CacheManager.playeroff);
            return true;
        }

        if (target == p) {
            sender.sendMessage(CacheManager.specyourself);
            return true;
        }

        CacheManager.inspec.add(p.getUniqueId());
        CacheManager.targetSystem.put(p.getUniqueId(), target.getUniqueId());
        p.setGameMode(CacheManager.gamemode_inspec);
        p.teleport(target);

        if (CacheManager.targetglow_enable) {
            //todo: сделать ебучую систему подсветки нахуй
        }

        if (CacheManager.bossbar_enable) {
            CacheManager.abstractBossBar = Bukkit.createBossBar(CacheManager.bossbar_message.replaceAll("%player%", target.getName()), BarColor.valueOf(CacheManager.bossbar_color), BarStyle.SOLID);
            CacheManager.abstractBossBar.addPlayer(p);
        }

        sender.sendMessage(CacheManager.messageinspec);
        return true;
    }
}


