package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static List<String> optionsList = new ArrayList<>();

    public static void main(String[] args)
    {
        //add your code here
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String url = br.readLine();
            String [] options = url.substring(url.indexOf('?') + 1, url.length()).split("&");

            for (int i = 0; i < options.length; i++)
            {
                if (options[i].contains("=")) {
                    System.out.print(options[i].substring(0, options[i].indexOf('=')) + " ");
                }
                else System.out.print(options[i] + " ");
            }
            System.out.println();
            checkObj(options);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static void  checkObj(String [] options)
    {
        for (int i = 0; i < options.length; i++)
        {
            if (options[i].trim().contains("obj"))
            {
                if (options[i].contains("."))
                {
                    alert(Double.parseDouble(options[i].substring(options[i].indexOf('=') + 1,options[i].length())));
                }
                else
                {
                    alert(options[i].substring(options[i].indexOf('=') + 1,options[i].length()));
                }
            }
        }
    }
}
