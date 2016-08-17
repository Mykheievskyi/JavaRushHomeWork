package com.javarush.test.level38.lesson06.home01;

/**
 * Created by dima on 15.08.16.
 */
public class ExceptionFactory
{
    public static Throwable getException(Enum enumiration) {
        if (enumiration != null)
        {
            if (enumiration instanceof ExceptionApplicationMessage) {
                return new Exception(enumiration.name().charAt(0) + enumiration.name().substring(1).toLowerCase().replace("_", " "));
            } else if (enumiration instanceof ExceptionDBMessage) {
                return new RuntimeException(enumiration.name().charAt(0) + enumiration.name().substring(1).toLowerCase().replace("_", " "));
            } else if (enumiration instanceof ExceptionUserMessage) {
                return new Error(enumiration.name().charAt(0) + enumiration.name().substring(1).toLowerCase().replace("_", " "));
            }
        }
        return new IllegalArgumentException();
    }
}

