package com.epam.training.moviereview.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    public void consoleOut(String message) {
        System.out.printf("> %s\n", message);
    }

    public String consoleIn(String message) {
        if (!message.contentEquals("")) {
            consoleOut(message);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        do {
            try {
                in = reader.readLine();
            } catch (IOException e) {
                System.out.println("Unexpected char!");
            }
        } while (in.contentEquals(""));
        return in;
    }
}
