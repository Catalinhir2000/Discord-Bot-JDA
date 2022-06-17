package org.example;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.example.commands.*;
import org.example.events.EventJoin;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final GatewayIntent[] INTENTS = {GatewayIntent.DIRECT_MESSAGES, GatewayIntent.DIRECT_MESSAGE_REACTIONS, GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.GUILD_BANS, GatewayIntent.GUILD_INVITES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_EMOJIS, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES};
    public static void main( String[] args ) throws LoginException, IOException {

        //JDA jda = new JDABuilder("OTc4MDA4MTYzMjk3MTY1Mzc0.Ga2UnT.og-mT5xXM4KQD79PUoJC2BLuYQ5I9QmsZT1wIo").build();
        //JDA jda = new JDABuilder(AccountType.BOT).setToken("").build();
        JDA jdaBuilder = JDABuilder.create("OTc4MDA4MTYzMjk3MTY1Mzc0.Ga2UnT.og-mT5xXM4KQD79PUoJC2BLuYQ5I9QmsZT1wIo", Arrays.asList(INTENTS))
                .enableCache(CacheFlag.VOICE_STATE)
                .setActivity(Activity.playing("Discord"))
                .setStatus(OnlineStatus.ONLINE)
                .addEventListeners(new EventJoin())
                .addEventListeners(new Calculate())
                .addEventListeners(new TestCommand())
                .addEventListeners(new SearchCommand())
                .addEventListeners(new FeedCommand())
                .addEventListeners(new InviteCommand())
                .addEventListeners(new KickCommand())
                .addEventListeners(new PlayCommand())
                .addEventListeners(new BanCommand())
                .build();
        //run AtomReader
//        AtomReader ar = new AtomReader();
//        var rezultate = ar.readAtom();
//        for (int i = 0; i < rezultate.size(); i++) {
//            System.out.println(rezultate.get(i));
//        }
//        Searcher s = new Searcher();
//        var rezultate = s.cautare();
//        System.out.println(rezultate);
    }
}
