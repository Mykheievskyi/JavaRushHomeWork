package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static  int max(int x, int y)
    {
        int i;
        if (x < y)
            i = y;
        else
            i = x;
        return i;
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String s1 = reader.readLine();
        int n1 = Integer.parseInt(s1);

        String s2 = reader.readLine();
        int n2 = Integer.parseInt(s2);

        String s3 = reader.readLine();
        int n3 = Integer.parseInt(s3);

        String s4 = reader.readLine();
        int n4 = Integer.parseInt(s4);


        int a, b;

        a = max(n1, n2);
        b = max(n3, n4);

        if (a > b)
            System.out.println(a);
        else
            System.out.println(b);


    }


}
