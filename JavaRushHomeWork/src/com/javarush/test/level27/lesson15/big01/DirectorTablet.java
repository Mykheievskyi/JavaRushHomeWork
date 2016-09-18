package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;


public class DirectorTablet
{
    public void printAdvertisementProfit() {
        Map<Date, Long> unsortedAdvertisementProfitMap = StatisticManager.getInstance().getAdvertisementProfit();
        NavigableMap<Date, Long> advertisementProfitMap = new TreeMap<Date, Long>();
        advertisementProfitMap.putAll(unsortedAdvertisementProfitMap);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        float totalAmount = 0;
        if (!advertisementProfitMap.isEmpty()) {
            for (Map.Entry<Date, Long> pair : advertisementProfitMap.descendingMap().entrySet()) {
                Date date = pair.getKey();
                Float amount = pair.getValue() / 100f;
                ConsoleHelper.writeMessage(String.format("%s - %.2f", sdf.format(date), amount));
                totalAmount += amount;
            }
            ConsoleHelper.writeMessage(String.format("Total - %.2f\n", totalAmount));
        }
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> unsortedcookWorkloadingMap = StatisticManager.getInstance().getCookWorkloading();
        NavigableMap<Date, Map<String, Integer>> cookWorkloadingMap = new TreeMap<Date, Map<String, Integer>>();
        cookWorkloadingMap.putAll(unsortedcookWorkloadingMap);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (!cookWorkloadingMap.isEmpty()) {
            for (Map.Entry<Date, Map<String, Integer>> pair : cookWorkloadingMap.descendingMap().entrySet()) {
                Date date = pair.getKey();
                Map<String, Integer> cookTimeMap = pair.getValue();
                Map<String, Integer> sortedCookTimeMap = new TreeMap();
                sortedCookTimeMap.putAll(cookTimeMap);
                ConsoleHelper.writeMessage(sdf.format(date));
                for (Map.Entry<String, Integer> innerPair : sortedCookTimeMap.entrySet())
                {
                    String cookName = innerPair.getKey();
                    int cookingTimeSeconds = innerPair.getValue();
                    int cookingTimeMinutes = cookingTimeSeconds % 60 == 0 ? cookingTimeSeconds / 60 : cookingTimeSeconds / 60 + 1;
                    if (cookingTimeMinutes <= 0)
                        continue;
                    ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, cookingTimeMinutes));
                }
                ConsoleHelper.writeMessage("");
            }
        }
    }

    public void printActiveVideoSet() {
    }

    public void printArchivedVideoSet() {
    }
}