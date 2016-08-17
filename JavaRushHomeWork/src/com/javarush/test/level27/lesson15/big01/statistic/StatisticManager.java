package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dima on 09.07.16.
 */
public class StatisticManager
{
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager()
    {
    }

    public static StatisticManager getInstance()
    {
        return instance;
    }

    public void register(EventDataRow data)
    {
        statisticStorage.put(data);
    }

    private class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> map =new HashMap<>();

        public StatisticStorage()
        {
            for (EventType type: EventType.values())
            {
                map.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data)
        {
            map.get(data.getType()).add(data);
        }
    }
}
