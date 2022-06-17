package org.example.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TestCommand extends ListenerAdapter {
    public String prefix = "!";

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(prefix + "test")) {
            event.getMessage().reply("Test command works!").queue();
        }
    }
}
