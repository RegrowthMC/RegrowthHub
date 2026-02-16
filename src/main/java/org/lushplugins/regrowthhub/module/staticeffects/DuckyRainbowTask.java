package org.lushplugins.regrowthhub.module.staticeffects;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class DuckyRainbowTask implements Runnable {
    private final Reference<World> world;
    private final BoundingBox[] duckAreas;

    public DuckyRainbowTask() {
        this.world = new WeakReference<>(Bukkit.getWorld("world"));
        this.duckAreas = new BoundingBox[]{
            BoundingBox.of(new Vector(1.5, 64.5, -68.5), 1, 1, 1),
            BoundingBox.of(new Vector(8.5, 64.5, -64.5), 1, 1, 1),
            BoundingBox.of(new Vector(7.5, 64.5, -61.5), 1, 1, 1)
        };
    }

    @Override
    public void run() {
        World world = this.world.get();
        if (world == null) {
            return;
        }

        for (BoundingBox duckArea : duckAreas) {
            if (world.getNearbyEntities(duckArea).isEmpty()) {
                return;
            }
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "em play Beach DuckyRainbow.yml");
    }

}
