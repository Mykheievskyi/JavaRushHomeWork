package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;


class AdvertisementStorage {
    private final List<Advertisement> videos = new ArrayList<>();

    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();

        add(new Advertisement(someContent, "1", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "2", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "3", 400, 2, 10 * 60));
        add(new Advertisement(someContent, "4", 400, 2, 20 * 60));
        add(new Advertisement(someContent, "5", 400, 2, 40 * 60));
        add(new Advertisement(someContent, "6", 400, 2, 30 * 60));
        add(new Advertisement(someContent, "7", 400, 2, 50 * 60));
        add(new Advertisement(someContent, "8", 150, 2, 20 * 60));
        add(new Advertisement(someContent, "9", 7000, 2, 10 * 60));
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public List<Advertisement> list() {
        return videos;
    }
}
