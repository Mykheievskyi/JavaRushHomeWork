package com.javarush.test.level39.lesson09.big01;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("/Users/dima/Desktop/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level39/lesson09/big01/logs/"));

        System.out.println("*************Задание 1*************");
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()) + ": ");
        System.out.println(logParser.getUniqueIPs(null, new Date()));
        System.out.println("Amigo: " + logParser.getIPsForUser("Amigo", null, null));
        System.out.println("LOGIN: " + logParser.getIPsForEvent(Event.LOGIN, null, null));
        System.out.println("OK: " + logParser.getIPsForStatus(Status.OK, null, null));

        System.out.println("*************Задание 2*************");

        System.out.println(logParser.getNumberOfUsers(new Date(), null));
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUserEvents("Eduard Petrovich Morozko", null, null));
        System.out.println(logParser.getUsersForIP("127.0.0.1", null, null));
        System.out.println(logParser.getLoggedUsers(null, null));
        System.out.println(logParser.getDownloadedPluginUsers(null, null));
        System.out.println(logParser.getSolvedTaskUsers(null, null));
        System.out.println(logParser.getDoneTaskUsers(null, null));
        System.out.println(logParser.getDoneTaskUsers(null, null, 15));
        System.out.println(logParser.getSolvedTaskUsers(null, null, 18));
        System.out.println(logParser.getWroteMessageUsers(null, null));
    }
}
