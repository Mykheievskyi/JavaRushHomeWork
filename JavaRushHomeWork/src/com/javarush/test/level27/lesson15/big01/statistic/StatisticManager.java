package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public final class StatisticManager
{
    private static StatisticManager instance = new StatisticManager();
    private final StatisticStorage statisticStorage = StatisticStorage.getInstance();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }


    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<Date, Long> getAdvertisementProfit() {
        Map<Date, Long> advertisementProfitMap = new HashMap<>();
        List<EventDataRow> videoSelectedEvents = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        if (!videoSelectedEvents.isEmpty())
        {
            for (int i = 0; i < videoSelectedEvents.size(); i++ ) {
                VideoSelectedEventDataRow eventDataRow = (VideoSelectedEventDataRow) videoSelectedEvents.get(i);
                Date listDate = eventDataRow.getDate();
                Calendar listCalendar = new GregorianCalendar();
                listCalendar.setTime(listDate);
                int listDay = listCalendar.get(Calendar.DAY_OF_MONTH);
                int listMonth = listCalendar.get(Calendar.MONTH);
                int listYear = listCalendar.get(Calendar.YEAR);
                long listProfit = eventDataRow.getAmount();
                long newProfit = listProfit;
                Date newDate = listDate;
                for (Map.Entry<Date, Long> pair : advertisementProfitMap.entrySet())
                {
                    Date mapDate = pair.getKey();
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(mapDate);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH);
                    int year = calendar.get(Calendar.YEAR);
                    long mapProfit = pair.getValue();
                    if (day == listDay && month == listMonth && year == listYear)
                    {
                        newProfit += mapProfit;
                        newDate = mapDate;
                        break;
                    }
                }
                advertisementProfitMap.put(newDate, newProfit);
            }
        }
        return advertisementProfitMap;
    }

    public Map<Date, Map<String, Integer>> getCookWorkloading() {
        Map<Date, Map<String, Integer>> cookWorkloadingMap = new HashMap<>();
        List<EventDataRow> cookedOrderEvents = statisticStorage.getStorage().get(EventType.COOKED_ORDER);
        if (!cookedOrderEvents.isEmpty())
        {
            //перебираем все события
            for (int i = 0; i < cookedOrderEvents.size(); i++ ) {
                CookedOrderEventDataRow eventDataRow = (CookedOrderEventDataRow) cookedOrderEvents.get(i);
                Date listDate = eventDataRow.getDate();
                Calendar listCalendar = new GregorianCalendar();
                listCalendar.setTime(listDate);
                int listDay = listCalendar.get(Calendar.DAY_OF_MONTH);
                int listMonth = listCalendar.get(Calendar.MONTH);
                int listYear = listCalendar.get(Calendar.YEAR);
                String listCookName = eventDataRow.getCookName();
                int listCookingTimeSeconds = eventDataRow.getTime();
                boolean isDateExist = false;
                //ищем есть ли уже в результате данные с такой датой
                for (Map.Entry<Date, Map<String, Integer>> pair : cookWorkloadingMap.entrySet())
                {
                    Date date = pair.getKey();
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(date);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH);
                    int year = calendar.get(Calendar.YEAR);
                    Map<String, Integer>  cookTimeMap = pair.getValue();
                    //если данные с такой датой есть
                    if (day == listDay && month == listMonth && year == listYear)
                    {
                        if (cookTimeMap != null)
                        {
                            //если уже есть данные для такого повара
                            if (cookTimeMap.containsKey(listCookName))
                            {
                                int cookingTimeSeconds = cookTimeMap.get(listCookName) + listCookingTimeSeconds;
                                cookTimeMap.put(listCookName, cookingTimeSeconds);
                                //если повар новый
                            } else
                            {
                                cookTimeMap.put(listCookName, listCookingTimeSeconds);
                            }
                            //если карта повар-время пустая
                        } else {
                            cookTimeMap = new HashMap<>();
                            cookTimeMap.put(listCookName, listCookingTimeSeconds);
                        }
                        isDateExist = true;
                        break;
                    }
                }
                //если данных по такой дате еще не было
                if (!isDateExist) {
                    Map<String, Integer>  cookTimeMap = new HashMap<>();
                    cookTimeMap.put(listCookName, listCookingTimeSeconds);
                    cookWorkloadingMap.put(listDate, cookTimeMap);
                }
            }

        }
        return cookWorkloadingMap;
    }

    private final static class StatisticStorage {
        private static StatisticStorage instance;
        private Map<EventType, List<EventDataRow>> storage;

        private StatisticStorage()
        {
            storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                List<EventDataRow> eventList = new ArrayList<>();
                storage.put(eventType, eventList);
            }
        }

        public static StatisticStorage getInstance() {
            if (instance == null) {
                instance = new StatisticStorage();
            }
            return instance;
        }

        private void put(EventDataRow data) {
            EventType eventType = data.getType();
            storage.get(eventType).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage()
        {
            return storage;
        }
    }
}