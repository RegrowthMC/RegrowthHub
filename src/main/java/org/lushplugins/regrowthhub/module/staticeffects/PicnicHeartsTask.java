package org.lushplugins.regrowthhub.module.staticeffects;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class PicnicHeartsTask implements Runnable {
    private final Reference<World> world;
    private final BoundingBox picnicArea;

    public PicnicHeartsTask() {
        this.world = new WeakReference<>(Bukkit.getWorld("world"));
        this.picnicArea = BoundingBox.of(new Vector(-49, 69, -30), 2.5, 1, 3.5);
    }

    @Override
    public void run() {
        World world = this.world.get();
        if (world == null) {
            return;
        }

        if (world.getNearbyEntities(this.picnicArea, (entity) -> entity.getType() != EntityType.ITEM_FRAME).size() >= 4) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "em play Grass Picnic.yml");
        }
    }
}
