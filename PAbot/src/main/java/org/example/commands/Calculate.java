package org.example.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.atomic.AtomicInteger;

public class Calculate extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");

        if (message[0].equalsIgnoreCase("!calculate")) {
            event.getChannel().sendMessage("Calculate").queue();
            if (message[1].equalsIgnoreCase("add")) {
                event.getChannel().sendMessage("Add result is: " + (Integer.parseInt(message[2]) + Integer.parseInt(message[3]))).queue();
            }
            if (message[1].equalsIgnoreCase("sub")) {
                event.getChannel().sendMessage("Subtract result is: " + (Integer.parseInt(message[2]) - Integer.parseInt(message[3]))).queue();
            }
            if (message[1].equalsIgnoreCase("mult")) {
                event.getChannel().sendMessage("Multiply result is: " + (Integer.parseInt(message[2]) * Integer.parseInt(message[3]))).queue();
            }
            if (message[1].equalsIgnoreCase("div")) {
                event.getChannel().sendMessage("Division result is: " + (Integer.parseInt(message[2]) / Integer.parseInt(message[3]))).queue();
            }
            if (message[1].equalsIgnoreCase("mod")) {
                event.getChannel().sendMessage("Modulo result is: " + (Integer.parseInt(message[2]) % Integer.parseInt(message[3]))).queue();
            }
        }

    }
}
