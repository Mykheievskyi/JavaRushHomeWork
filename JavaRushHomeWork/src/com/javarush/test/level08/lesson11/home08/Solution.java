package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        for(int m = 0; m < array.length - 1; m++)
        {
            for (int n = 0; n < array.length - m - 1; n++)
            {
                if(array[n] < array[n + 1]) swap(array, n, n + 1);
            }
        }
    }

    public static void swap(int[] array, int i, int j)
    {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }
}
