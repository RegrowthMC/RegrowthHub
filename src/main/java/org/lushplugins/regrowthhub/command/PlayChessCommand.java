package org.lushplugins.regrowthhub.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lushplugins.lushlib.command.Command;
import org.lushplugins.lushlib.libraries.chatcolor.ChatColorHandler;

import java.util.List;

public class PlayChessCommand extends Command {

    public PlayChessCommand() {
        super("playchess");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args, @NotNull String[] fullArgs) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Command must be ran by a player");
            return true;
        }

        if (args.length == 0) {
            ChatColorHandler.sendMessage(sender, "&#ff6969Incorrect usage, try &#d13636/playchess <player>");
            return true;
        }

        player.performCommand(String.format("chess challenge player LobbyBoard %s white", args[0]));
        return true;
    }

    @Override
    public @Nullable List<String> tabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args, @NotNull String[] fullArgs) {
        return args.length == 1 ? Bukkit.getOnlinePlayers().stream().map(Player::getName).toList() : null;
    }
}
