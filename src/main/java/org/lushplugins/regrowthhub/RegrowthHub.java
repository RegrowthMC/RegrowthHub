package org.lushplugins.regrowthhub;

import org.bukkit.Bukkit;
import org.lushplugins.lushlib.LushLib;
import org.lushplugins.lushlib.plugin.SpigotPlugin;
import org.lushplugins.regrowthhub.command.PlayChessCommand;
import org.lushplugins.regrowthhub.module.staticeffects.DuckyRainbowTask;
import org.lushplugins.regrowthhub.module.staticeffects.PicnicHeartsTask;
import org.lushplugins.regrowthhub.module.swaphandfix.SwapHandFixListener;

// TODO: Consider merging into main Regrowth plugin as modules
public final class RegrowthHub extends SpigotPlugin {

    @Override
    public void onLoad() {
        LushLib.getInstance().enable(this);
    }

    @Override
    public void onEnable() {
        registerListeners(
            new SwapHandFixListener()
        );

        registerCommand(new PlayChessCommand());

        Bukkit.getScheduler().runTaskTimer(this, new DuckyRainbowTask(), 20, 100);
        Bukkit.getScheduler().runTaskTimer(this, new PicnicHeartsTask(), 20, 1200);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
