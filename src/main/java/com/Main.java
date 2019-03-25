package com;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Main {

    private static final String token = "TOKEN";

    public static void main(String[] args) {

        try {
            JDA jda = new JDABuilder(token)         // The token of the account that is logging in.
                    .addEventListener(new MessageHandler())  // An instance of a class that will handle events.
                    .build();
            jda.awaitReady(); // Blocking guarantees that JDA will be completely loaded.
            System.out.println("Finished Building JDA!");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
