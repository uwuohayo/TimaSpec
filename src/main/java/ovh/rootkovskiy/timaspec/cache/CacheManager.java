package ovh.rootkovskiy.timaspec.cache;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.boss.BossBar;
import ovh.rootkovskiy.timaspec.Main;
import ovh.rootkovskiy.timaspec.utils.ColorUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CacheManager {

    public ArrayList<UUID> inspec;
    public HashMap<UUID, UUID> targetSystem;
    public World w;
    public int x;
    public int y;
    public int z;
    public int yaw;
    public int pitch;
    public Location spawnlocation;

    public String notplayer;
    public String noperm;
    public String usage;
    public String usageexit;
    public String usagereload;
    public String successreload;
    public String messageinspec;
    public String messageoutspec;
    public String playeroff;
    public String specyourself;
    public String exitspecnonspec;
    public String cannotsend;

    public Boolean radius_enable;
    public String radius_message;
    public int radius_value;

    public Boolean bossbar_enable;
    public String bossbar_message;
    public String bossbar_color;

    public BossBar abstractBossBar;

    public void loadArrays() {
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
        bossbar_message = Main.getInstance().getConfig().getString("bossbar.message");
        bossbar_color = Main.getInstance().getConfig().getString("bossbar.color");
    }
}
