package org.example.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.Searcher;

import java.util.ArrayList;
import java.util.List;

public class SearchCommand extends ListenerAdapter {
    List<String> list = new ArrayList<>();
    Searcher s = new Searcher();
    List<String> result = new ArrayList<>();
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("!search")) {
            event.getChannel().sendMessage("Search").queue();
            for (int i = 1; i < message.length; i++) {
                list.add(message[i]);
            }
            result = s.cautare(list);
            System.out.println(result);
            event.getChannel().sendMessage(result.toString()).queue();
            result.clear();
            list.clear();
        }
        }


}
