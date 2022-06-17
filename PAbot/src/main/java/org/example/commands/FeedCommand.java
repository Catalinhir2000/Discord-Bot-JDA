package org.example.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.AtomReader;

import java.io.IOException;

public class FeedCommand extends ListenerAdapter {
    AtomReader ar = new AtomReader();
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("!feed")) {
            event.getChannel().sendMessage("This is feed command").queue();
            try {
                var rezultate = ar.readAtom();
                for (int i = 0; i < 9; i++) {
                    event.getChannel().sendMessage(rezultate.get(i)).queue();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
