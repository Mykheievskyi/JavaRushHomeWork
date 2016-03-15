package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dima on 14.03.16.
 */
public class ConsoleHelper
{
    public static BufferedReader console = new BufferedReader( new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String text = "";

        while (true) {
            try {
                text = console.readLine();
                break;
            } catch (IOException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

        return text;
    }

    public static int readInt()
    {
        int result = 0;

        while (true)
        {
            try {
                result = Integer.parseInt(readString());
                break;
            }catch (NumberFormatException e)
            {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return result;
    }
}
