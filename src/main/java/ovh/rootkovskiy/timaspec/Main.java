package ovh.rootkovskiy.timaspec;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ovh.rootkovskiy.timaspec.cache.CacheManager;

public final class Main extends JavaPlugin {

    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    private static CacheManager cacheManager = new CacheManager();
    public static CacheManager getCacheManager() { return cacheManager; }

    @Override
    public void onEnable() {
        instance = this;
        cacheManager.loadArrays();
        new Loader().loadAll();
        saveDefaultConfig();
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
