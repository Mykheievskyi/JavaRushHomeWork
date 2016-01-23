package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] array = s.toCharArray();
        for(int x = 0; x < array.length; x++)
        {
            if( x == 0 && Character.isLetter(array[0]))
            {
                array[0] = Character.toUpperCase(array[0]);
            }
            else if(array[x] == ' ' && Character.isLetter(array[x+1]))
            {
                array[x+1]=Character.toUpperCase(array[x+1]);
            }
        }
        for(char ch : array)
        {
            System.out.print(ch);
        }
    }


}
