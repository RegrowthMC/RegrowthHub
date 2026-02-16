package org.lushplugins.regrowthhub.command;

import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;

@Command("playchess")
@SuppressWarnings("unused")
public class PlayChessCommand {

    @Command("playchess")
    public void playChess(BukkitCommandActor actor, Player target) {
        Player player = actor.requirePlayer();
        player.performCommand(String.format("chess challenge player LobbyBoard %s white", target.getName()));
    }
}
