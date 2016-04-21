package com.javarush.test.level33.lesson15.big01;

/**
 * Created by dima on 13.04.16.
 */
public class ExceptionHandler extends Exception
{
    //будет выводить краткое описание исключения.
    public static void log(Exception e)
    {
        Helper.printMessage(e.getMessage());
    }
}
