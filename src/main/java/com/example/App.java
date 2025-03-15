package com.example;

import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        String greeting;

        if (currentTime.getHour() < 12) {
            greeting = "Good morning";
        } else {
            greeting = "Good afternoon";
        }

        System.out.println(greeting + ", Karan!, Welcome to COMP367");
    }
}
