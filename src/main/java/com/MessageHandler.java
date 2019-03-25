package com;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageHandler extends ListenerAdapter {

    public MessageHandler() {}

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //These are provided with every event in JDA
        JDA jda = event.getJDA();                       //JDA, the core of the api.
        long responseNumber = event.getResponseNumber();//The amount of discord events that JDA has received since the last reconnect.

        //Event specific information
        User author = event.getAuthor();                //The user that sent the message
        Message message = event.getMessage();           //The message that was received.
        MessageChannel channel = event.getChannel();    //This is the MessageChannel that the message was sent to.
        //  This could be a TextChannel, PrivateChannel, or Group!

        String msg = message.getContentDisplay();              //This returns a human readable version of the Message. Similar to
        // what you would see in the client.
        System.out.println(msg);

        if (event.isFromType(ChannelType.TEXT)) { //If this message was sent to a Guild TextChannel

            Guild guild = event.getGuild();             //The Guild that this message was sent in. (note, in the API, Guilds are Servers)
            TextChannel textChannel = event.getTextChannel(); //The TextChannel that this message was sent to.
            Member member = event.getMember();          //This Member that sent the message. Contains Guild specific information about the User!

            if(!textChannel.getName().equals("confessionário") && !textChannel.getName().equals("t"))
                return;

            String name;
            if (message.isWebhookMessage())
            {
                name = author.getName();                //If this is a Webhook message, then there is no Member associated
            }                                           // with the User, thus we default to the author for name.
            else
            {
                name = member.getEffectiveName();       //This will either use the Member's nickname if they have one,
            } // otherwise it will default to their username. (User#getName())


            if (msg.equals("!mandamentos")) {
                String mandamentos = "```python\n" +
                        "1. Amar o Oráculo acima de tudo o resto.\n" +
                        "2. Não tomar o Seu Santo nome em vão.\n" +
                        "3. Ir às passagens de mês e festas no geral.\n" +
                        "4. Honrar Vodka, Uísque e Cerveja.\n" +
                        "5. Não ficar sóbrio.\n" +
                        "6. Não pecar contra o álcool.\n" +
                        "7. Tentar não sujar ao gregar.\n" +
                        "8. Não deixar copos por beber.\n" +
                        "9. Encher o copo do próximo.\n" +
                        "10. Confirmar a Fé através do Batismo.\n" +
                        "```";

                textChannel.sendMessage(mandamentos).queue();
            }
        }
    }
}
