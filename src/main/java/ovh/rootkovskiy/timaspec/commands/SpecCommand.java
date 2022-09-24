package ovh.rootkovskiy.timaspec.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ovh.rootkovskiy.timaspec.Main;

public class SpecCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        //command spec

        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.getCacheManager().notplayer);
            return true;
        }

        if (!sender.hasPermission("timaspec.spec")) {
            sender.sendMessage(Main.getCacheManager().noperm);
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(Main.getCacheManager().usage);
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null || !target.isOnline()) {
            sender.sendMessage(Main.getCacheManager().playeroff);
            return true;
        }

        if (target == p) {
            sender.sendMessage(Main.getCacheManager().specyourself);
            return true;
        }

        Main.getCacheManager().inspec.add(p.getUniqueId());
        Main.getCacheManager().targetSystem.put(p.getUniqueId(), target.getUniqueId());
        p.setGameMode(GameMode.SPECTATOR);
        p.teleport(target);

        if (Main.getCacheManager().bossbar_enable) {
            Main.getCacheManager().abstractBossBar = Bukkit.createBossBar(Main.getCacheManager().bossbar_message.replaceAll("%player%", target.getName()), BarColor.valueOf(Main.getCacheManager().bossbar_color), BarStyle.SOLID);
            Main.getCacheManager().abstractBossBar.addPlayer(p);
        }

        sender.sendMessage(Main.getCacheManager().messageinspec);
        return true;
    }
}


