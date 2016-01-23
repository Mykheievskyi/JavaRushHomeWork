package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран с
умму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int  s = 0;

        for (boolean isExit = false; !isExit; )
        {
            String sn = reader.readLine();
            int n = Integer.parseInt(sn);
            s = s + n;
            isExit = sn.equals("-1");
        }
        System.out.print(s);
    }
}
