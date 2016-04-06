package com.javarush.test.level15.lesson12.home04;

/**
 * Created by dima on 24.03.16.
 */
public class Earth implements Planet {

    private static Earth instance;

    private Earth() {}

    public static Earth getInstance() {
        if(instance == null) {
            instance = new Earth();
        }
        return instance;
    }

}