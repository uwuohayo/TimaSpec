package ovh.rootkovskiy.timaspec;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ovh.rootkovskiy.timaspec.cache.CacheManager;
import ovh.rootkovskiy.timaspec.utils.ConsoleUtils;

public final class Main extends JavaPlugin {

    public static Main getInstance() {
        return instance;
    }
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        new Loader().loadAll();
        saveDefaultConfig();
        CacheManager.loadArrays();
        getLogger().info("Plugin enabled");
        System.out.println(ConsoleUtils.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_CYAN + "TimaSpec " + getDescription().getVersion() + " Loaded and Enabled!" + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_CYAN + "MC Core Version: " + Bukkit.getBukkitVersion() + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_CYAN + "VK: @timurroot" + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + ConsoleUtils.ANSI_RESET);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
        System.out.println(ConsoleUtils.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_CYAN + "TimaSpec " + getDescription().getVersion() + " Disabled!" + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_CYAN + "MC Core Version: " + Bukkit.getBukkitVersion() + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_CYAN + "VK: @timurroot" + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_CYAN + "Goodbye ;p" + ConsoleUtils.ANSI_RESET);
        System.out.println(ConsoleUtils.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + ConsoleUtils.ANSI_RESET);
    }
}
