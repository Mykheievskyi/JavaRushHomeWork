package com.javarush.test.level07.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно добавить в программу новую функциональность
Задача:  Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter). Потом она конвертирует строки
в верхний регистр (Мама превращается в МАМА) и выводит их на экран.
Новая задача: Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter).
Потом программа строит новый список. Если в строке чётное число букв, строка удваивается, если нечётное – утраивается.
Программа выводит содержимое нового списка на экран.
Пример ввода:
Кот
Коты
Я
Пример вывода:
Кот Кот Кот
Коты Коты
Я Я Я
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }



        ArrayList<String> result = Solution(list);

        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i));
        }


    }

    public static ArrayList<String> Solution(ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            String s = list.get(i);
            if (s.length() % 2 == 0)
            {
                list.set(i, list.get(i) + " " + list.get(i));
            }
            else
            {
                list.set(i, list.get(i) + " " + list.get(i) + " " + list.get(i));
            }
        }
        return list;
    }
}
