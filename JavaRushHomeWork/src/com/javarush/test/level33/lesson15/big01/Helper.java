package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by dima on 13.04.16.
 */
public class Helper
{
    //будет генерировать случайную строку
    public static String generateRandomString()
    {
        SecureRandom random = new SecureRandom();

        return new BigInteger(130, random).toString(32);
    }

    public static void printMessage(String message)
    {
        System.out.println(message);
    }
}
