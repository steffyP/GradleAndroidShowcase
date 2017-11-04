package com.example;

import java.util.Random;

public class JokeProvider {

    // jokes taken from http://www.short-funny.com
    private static final String[] jokes = new String[]
            {"When I see lovers' names carved in a tree, I don't think it's sweet. I just think it's surprising how many people bring a knife on a date.",
                    "Can a kangaroo jump higher than a house? \n" +
                            "-\n" +
                            "Of course, a house doesn’t jump at all.",
                    "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                            "\n" +
                            "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                            "\n" +
                            "Doctor: \"Nine.\"",
                    "A man asks a farmer near a field, “Sorry sir, would you mind if I crossed your field instead of going around it? You see, I have to catch the 4:23 train.”\n" +
                            "\n" +
                            "The farmer says, “Sure, go right ahead. And if my bull sees you, you’ll even catch the 4:11 one.”",
                    " Anton, do you think I’m a bad mother?\n" +
                            "\n" +
                            "My name is Paul.",
                    "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.\n",
                    "What is the difference between a snowman and a snowwoman?\n" +
                            "-\n" +
                            "Snowballs.",
                    "Mother: \"How was school today, Patrick?\"\n" +
                            "\n" +
                            "Patrick: \"It was really great mum! Today we made explosives!\"\n" +
                            "\n" +
                            "Mother: \"Ooh, they do very fancy stuff with you these days. And what will you do at school tomorrow?\"\n" +
                            "\n" +
                            "Patrick: \"What school?\"",
                    "\"Mom, where do tampons go?\"\n" +
                            "\n" +
                            "\"Where the babies come from, darling.\"\n" +
                            "\n" +
                            "\"In the stork?\"",
                    "Doctor: “I’ve found a great new drug that can help you with your sleeping problem.”\n" +
                            " \n" +
                            "Patient: “Great, how often do I have to take it?”\n" +
                            " \n" +
                            "Doctor: “Every two hours.”",
                    "Sleep with an open window tonight! \n" +
                            "\n" +
                            "1400 mosquitos like that. 420 mosquitos commented on it. 210 mosquitos shared this. \n" +
                            "\n" +
                            "One mosquito invited for the event. 2800 mosquitos will be attending the event.",
                    " “My wife suffers from a drinking problem.”\n" +
                            "-\n" +
                            "“Oh is she an alcoholic?”\n" +
                            "-\n" +
                            "“No, I am, but she’s the one who suffers.”",
                    "A wife goes to consult a psychiatrist about her husband: “My husband is acting so weird. He drinks his morning coffee and then he goes and eats the mug! He only leaves the handle!”\n" +
                            " \n" +
                            "Psychiatrist: “Yes, that is weird. The handle is the best part.“",
                    "Father: “Son, you were adopted.”\n" +
                            " \n" +
                            "Son: “What?! I knew it! I want to meet my biological parents!”\n" +
                            " \n" +
                            "Father: “We are your biological parents. Now pack up, the new ones will pick you up in 20 minutes.”",
                    "Time is money. Therefore, ATMs are time machines."


            };

    private static final Random random = new Random();

    public static String getJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
