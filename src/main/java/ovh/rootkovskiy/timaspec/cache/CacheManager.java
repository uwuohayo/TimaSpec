package ovh.rootkovskiy.timaspec.cache;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.boss.BossBar;
import ovh.rootkovskiy.timaspec.Main;
import ovh.rootkovskiy.timaspec.utils.ColorUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CacheManager {

    public static ArrayList<UUID> inspec;
    public static HashMap<UUID, UUID> targetSystem;
    public static World w;
    public static int x;
    public static int y;
    public static int z;
    public static int yaw;
    public static int pitch;
    public static Location spawnlocation;

    public static String notplayer;
    public static String noperm;
    public static String usage;
    public static String usageexit;
    public static String usagereload;
    public static String successreload;
    public static String messageinspec;
    public static String messageoutspec;
    public static String playeroff;
    public static String specyourself;
    public static String exitspecnonspec;
    public static String cannotsend;

    public static Boolean radius_enable;
    public static String radius_message;
    public static int radius_value;

    public static Boolean bossbar_enable;
    public static String bossbar_message;
    public static String bossbar_color;

    public static BossBar abstractBossBar;

    public static Boolean targetglow_enable;
    public static String targetglow_color;

    public static GameMode gamemode_inspec;
    public static GameMode gamemode_exitspec;

    public static void loadArrays() {
        inspec = new ArrayList<>();
        targetSystem = new HashMap<>();
        w = Bukkit.getWorld(Main.getInstance().getConfig().getString("world"));
        x = Main.getInstance().getConfig().getInt("x");
        y = Main.getInstance().getConfig().getInt("y");
        z = Main.getInstance().getConfig().getInt("z");
        yaw = Main.getInstance().getConfig().getInt("yaw");
        pitch = Main.getInstance().getConfig().getInt("pitch");
        spawnlocation = new Location(w, x, y, z, yaw, pitch);

        notplayer = ColorUtils.format(Main.getInstance().getConfig().getString("notplayer"));
        noperm = ColorUtils.format(Main.getInstance().getConfig().getString("noperm"));
        usage = ColorUtils.format(Main.getInstance().getConfig().getString("usage"));
        usageexit = ColorUtils.format(Main.getInstance().getConfig().getString("usageexit"));
        usagereload = ColorUtils.format(Main.getInstance().getConfig().getString("usagereload"));
        successreload = ColorUtils.format(Main.getInstance().getConfig().getString("successreload"));
        messageinspec = ColorUtils.format(Main.getInstance().getConfig().getString("messageinspec"));
        messageoutspec = ColorUtils.format(Main.getInstance().getConfig().getString("messageoutspec"));
        playeroff = ColorUtils.format(Main.getInstance().getConfig().getString("playeroff"));
        specyourself = ColorUtils.format(Main.getInstance().getConfig().getString("specyourself"));
        exitspecnonspec = ColorUtils.format(Main.getInstance().getConfig().getString("exitspecnonspec"));
        cannotsend = ColorUtils.format(Main.getInstance().getConfig().getString("cannotsend"));

        radius_enable = Main.getInstance().getConfig().getBoolean("radius.enable");
        radius_message = ColorUtils.format(Main.getInstance().getConfig().getString("radius.message"));
        radius_value = Main.getInstance().getConfig().getInt("radius.value");

        bossbar_enable = Main.getInstance().getConfig().getBoolean("bossbar.enable");
        bossbar_message = ColorUtils.format(Main.getInstance().getConfig().getString("bossbar.message"));
        bossbar_color = Main.getInstance().getConfig().getString("bossbar.color");

        targetglow_enable = Main.getInstance().getConfig().getBoolean("targetglow.enable");
        targetglow_color = Main.getInstance().getConfig().getString("targetglow.color");

        gamemode_inspec = GameMode.valueOf(Main.getInstance().getConfig().getString("gamemode.inspec"));
        gamemode_exitspec = GameMode.valueOf(Main.getInstance().getConfig().getString("gamemode.exitspec"));
    }
}
