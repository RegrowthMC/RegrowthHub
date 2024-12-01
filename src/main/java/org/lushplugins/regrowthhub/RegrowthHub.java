package org.lushplugins.regrowthhub;

import org.lushplugins.lushlib.LushLib;
import org.lushplugins.lushlib.plugin.SpigotPlugin;
import org.lushplugins.regrowthhub.hook.command.PlayChessCommand;
import org.lushplugins.regrowthhub.hook.listener.PlayerListener;

public final class RegrowthHub extends SpigotPlugin {

    @Override
    public void onLoad() {
        LushLib.getInstance().enable(this);
    }

    @Override
    public void onEnable() {
        registerListeners(
            new PlayerListener()
        );

        registerCommand(new PlayChessCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
