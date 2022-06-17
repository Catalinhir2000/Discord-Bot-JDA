package org.example.commands;

import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class PlayCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("!play")) {
            event.getChannel().sendMessage("Playing").queue();

            VoiceChannel voiceChannel = event.getMember().getVoiceState().getChannel();
            AudioManager audioManager = event.getGuild().getAudioManager();
            audioManager.openAudioConnection(voiceChannel);



        }
    }
}
