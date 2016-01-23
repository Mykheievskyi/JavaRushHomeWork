package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sn1 = reader.readLine();
        int n1 = Integer.parseInt(sn1);

        String sn2 = reader.readLine();
        int n2 = Integer.parseInt(sn2);

        String sn3 = reader.readLine();
        int n3 = Integer.parseInt(sn3);

        int a, b;

        a = max(n1, n2);
        b = min(a, n3);



        System.out.print(b);

    }

    public static int  max(int x, int y)
    {
        int a;
        if(x < y)
            a = y;
        else
            a = x;
        return a;
    }

    public static int  min(int q, int w)
    {
        int f;
        if(q < w)
        {
            f = q;
        }
        else
        {
            f = w;
        }
        return f;
    }
}
