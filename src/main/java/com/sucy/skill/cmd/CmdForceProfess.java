/**
 * SkillAPI
 * com.sucy.skill.cmd.CmdForceProfess
 * <p>
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2014 Steven Sucy
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software") to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sucy.skill.cmd;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.player.PlayerData;
import com.sucy.skill.language.RPGFilter;
import mc.promcteam.engine.mccore.commands.CommandManager;
import mc.promcteam.engine.mccore.commands.ConfigurableCommand;
import mc.promcteam.engine.mccore.commands.IFunction;
import mc.promcteam.engine.mccore.config.Filter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A command that allows a player to profess through classes
 */
public class CmdForceProfess implements IFunction {
    private static final String NOT_PLAYER     = "not-player";
    private static final String CANNOT_USE     = "cannot-use";
    private static final String INVALID_CLASS  = "invalid-class";
    private static final String SUCCESSS       = "success";
    private static final String PROFESSED      = "professed";
    private static final String CANNOT_PROFESS = "cannot-profess";
    private static final String DISABLED       = "world-disabled";

    /**
     * Runs the command
     *
     * @param cmd    command that was executed
     * @param plugin plugin reference
     * @param sender sender of the command
     * @param args   argument list
     */
    @Override
    public void execute(ConfigurableCommand cmd, Plugin plugin, CommandSender sender, String[] args) {
        // Only players have profession options
        if (args.length < 2) {
            CommandManager.displayUsage(cmd, sender);
        } else {
            boolean silent = Arrays.stream(args).anyMatch(s -> s.equalsIgnoreCase("-s"));
            if (silent)
                args = Arrays.stream(args).filter(s -> !s.equalsIgnoreCase("-s"))
                        .collect(Collectors.toList()).toArray(new String[0]);

            OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
            if (player == null) {
                cmd.sendMessage(sender, NOT_PLAYER, ChatColor.RED + "That is not a valid player name");
                return;
            }

            String name = args[1];
            for (int i = 2; i < args.length; i++) name += ' ' + args[i];

            PlayerData data   = SkillAPI.getPlayerData(player);
            RPGClass   target = SkillAPI.getClass(name);

            // Invalid class
            if (target == null) {
                cmd.sendMessage(sender, INVALID_CLASS, ChatColor.RED + "That is not a valid class");
            }

            // Can profess
            else if (data.canProfess(target)) {
                data.profess(target);
                if (player.isOnline()) {
                    cmd.sendMessage(sender, SUCCESSS, ChatColor.GOLD + "{player}" + ChatColor.DARK_GREEN + " is now a " + ChatColor.GOLD + "{class}", Filter.PLAYER.setReplacement(player.getName()), RPGFilter.CLASS.setReplacement(target.getName()));
                    if (!silent) {
                        cmd.sendMessage((Player) player, PROFESSED, ChatColor.DARK_GREEN + "You are now a " + ChatColor.GOLD + "{class}", RPGFilter.CLASS.setReplacement(target.getName()));
                    }
                }
            }

            // Cannot profess
            else {
                cmd.sendMessage(sender, CANNOT_PROFESS, ChatColor.RED + "They cannot profess to this class currently");
            }
        }
    }
}
