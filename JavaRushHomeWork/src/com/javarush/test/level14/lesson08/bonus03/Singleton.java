package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by dima on 01.02.16.
 */
public class Singleton
{
    private static Singleton singleton;
    private Singleton() {}

    public static Singleton getInstance()
    {
        if (singleton == null)
        return  singleton = new Singleton();

        return singleton;
    }


}
