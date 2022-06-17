package org.example.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InviteCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("!invite")) {
            event.getChannel().sendMessage("Here is the invite link: " + event.getChannel().createInvite().complete().getUrl()).queue();//make sure that the invite creation is complete and then after gets the URL.
        }
    }

}
