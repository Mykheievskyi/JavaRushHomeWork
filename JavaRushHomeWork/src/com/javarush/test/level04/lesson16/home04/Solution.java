package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();

        String sy = reader.readLine();
        int y = Integer.parseInt(sy);

        String sm = reader.readLine();
        int m = Integer.parseInt(sm);

        String sd = reader.readLine();
        int d = Integer.parseInt(sd);

        System.out.println("Меня зовут " + name);
        System.out.println("Я родился " + d +"."+ m +"."+ y);
    }
}
