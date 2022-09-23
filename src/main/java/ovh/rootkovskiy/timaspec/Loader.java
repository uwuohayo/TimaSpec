package ovh.rootkovskiy.timaspec;

import org.bukkit.Bukkit;
import ovh.rootkovskiy.timaspec.commands.ExitspecCommand;
import ovh.rootkovskiy.timaspec.commands.ReloadspecCommand;
import ovh.rootkovskiy.timaspec.commands.SpecCommand;

public class Loader {
    public void loadAll() {
        Bukkit.getPluginCommand("spec").setExecutor(new SpecCommand());
        Bukkit.getPluginCommand("exitspec").setExecutor(new ExitspecCommand());
        Bukkit.getPluginCommand("reloadspec").setExecutor(new ReloadspecCommand());
        Main.getInstance().getServer().getPluginManager().registerEvents(new Events(), Main.getInstance());
    }
}
