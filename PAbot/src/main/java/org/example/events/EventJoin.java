package org.example.events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.*;
import net.dv8tion.jda.api.utils.cache.*;

public class EventJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        //checks the id of the server
        if (!event.getGuild().getId().equals("978001576255979560")){
            return;
        }
        event.getGuild().getTextChannelById("978001576826392608").sendMessage("Welcome " + event.getMember().getAsMention() + " to the server!").queue();
        //event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("978001576826392609")).queue();
    }
}
