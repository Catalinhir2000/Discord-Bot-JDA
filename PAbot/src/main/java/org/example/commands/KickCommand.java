package org.example.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class KickCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        var mesaj = event.getMessage();
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("!kick")) {
            event.getChannel().sendMessage("You have been kicked from the server").queue();
            event.getGuild().kick(mesaj.getMentionedMembers().get(0), "asdead").queue();
        }

    }


}


