package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 26.04.16.
 */

class AdvertisementStorage
{
    private static AdvertisementStorage instance;

    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage()
    {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));   //10 min
    }

    public static AdvertisementStorage getInstance()
    {
       if (instance == null)
       {
           instance = new AdvertisementStorage();
       }

       return instance;
    }

    // который вернет список всех существующих доступных видео
    public List<Advertisement> list()
    {
        return videos;
    }

    //добавит новое видео в список videos
    public void add(Advertisement advertisement)
    {
        videos.add(advertisement);
    }

}
