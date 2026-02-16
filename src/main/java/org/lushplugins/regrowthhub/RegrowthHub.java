package org.lushplugins.regrowthhub;

import org.bukkit.Bukkit;
import org.lushplugins.lushlib.plugin.SpigotPlugin;
import org.lushplugins.regrowthhub.command.PlayChessCommand;
import org.lushplugins.regrowthhub.module.staticeffects.DuckyRainbowTask;
import org.lushplugins.regrowthhub.module.staticeffects.PicnicHeartsTask;
import org.lushplugins.regrowthhub.module.swaphandfix.SwapHandFixListener;
import revxrsal.commands.bukkit.BukkitLamp;

public final class RegrowthHub extends SpigotPlugin {

    @Override
    public void onEnable() {
        registerListeners(
            new SwapHandFixListener()
        );

        Bukkit.getScheduler().runTaskTimer(this, new DuckyRainbowTask(), 20, 100);
        Bukkit.getScheduler().runTaskTimer(this, new PicnicHeartsTask(), 20, 1200);

        BukkitLamp.builder(this)
            .build()
            .register(new PlayChessCommand());
    }
}
