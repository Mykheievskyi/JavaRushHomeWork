package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код

        List<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maxChar = 0;

        for (int i = 0; i < 5; i++)
        {
            String text = reader.readLine();
            list.add(text);
        }
        reader.close();

        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).length() > maxChar)
            {
                maxChar = list.get(i).length();
            }
        }
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).length()== maxChar)
                System.out.println(list.get(i));
        }


    }
}
