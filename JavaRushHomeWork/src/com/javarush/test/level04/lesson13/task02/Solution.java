package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sm = reader.readLine();
        int m = Integer.parseInt(sm);

        String sn = reader.readLine();
        int n = Integer.parseInt(sn);

        for (int x = 1; x <= m; x++)
        {
            for (int y = 1; y <= n; y++)
                System.out.print("8");
            System.out.println(" ");
        }
    }
}
