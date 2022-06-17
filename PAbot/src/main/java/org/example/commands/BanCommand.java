package org.example.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BanCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        var mesaj = event.getMessage();
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("!ban")) {
            event.getChannel().sendMessage("You have been banned from the server").queue();
            event.getGuild().ban(mesaj.getMentionedMembers().get(0), 1).queue();
        }
    }
}
