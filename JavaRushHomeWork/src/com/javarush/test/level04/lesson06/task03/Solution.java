package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        int n1 = Integer.parseInt(s1);

        String s2 = reader.readLine();
        int n2 = Integer.parseInt(s2);

        String s3 = reader.readLine();
        int n3 = Integer.parseInt(s3);

        int m1, m2, m3;

        if (max(n1, n2) < n3)
        {
            m3 = n3;
            m1 = min(n1, n2);
            m2 = max(n1, n2);
        }
        else
        {
            m3 = max(n1, n2);
            m1= min(min(n1, n2), n3);
            m2 = max(min(n1,n2), n3);
        }

        System.out.println (m3 + " " + m2 + " " + m1);
    }

    public static int min(int x, int y)
    {
        int i;
        if (x < y)
            i = x;
        else
            i = y;
        return i;
    }
    public static int max(int x, int y)
    {
        int i;
        if (x > y)
            i = x;
        else
            i = y;
        return i;
    }
}
