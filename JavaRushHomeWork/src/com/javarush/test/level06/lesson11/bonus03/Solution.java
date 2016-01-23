package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int  s;
        int[] num = new int[5];

        for (int i = 0; i < 5; i++)
        {
            num[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(num);
        for (int i = 0; i < num.length; i++)
        {
            System.out.println(num[i]);
        }



        /*for (int m = numbers.length - 1; m >= n; m++)
        {
            for (int n = m; n < 5; n++)
            {
                s =  min(numbers[m], numbers[m + n]);
                System.out.println(s);
            }

        }*/

    }

    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }
}
