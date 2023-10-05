package org.feastgroup;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


//author 41zen.

public class Main extends ListenerAdapter {
    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault("YOUR_APP_TOKEN")

                .enableIntents(GatewayIntent.GUILD_MODERATION, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.MESSAGE_CONTENT)
                .build();
        jda.addEventListener(new Main());

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Guild guild = event.getGuild();
        MessageChannel channel1 = guild.getTextChannelById("SELECTED_ADVICE_CHANNEL_ID_BY_STRING");
        if (channel1 == event.getChannel()) {
            Message message = event.getMessage();
            Emoji greenmarkemoji = Emoji.fromUnicode("U+2705");      //Create an emoji using Unicode
            Emoji redcrossemoji = Emoji.fromUnicode("U+274C");
            message.addReaction(greenmarkemoji).queue(); //And add it in the method.Also you can add directly Emoji.fromUnicode() method
            message.addReaction(redcrossemoji).queue();



        }
    }
}               