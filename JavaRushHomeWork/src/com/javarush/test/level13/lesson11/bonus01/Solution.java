package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        List<Integer>  list = new ArrayList<Integer>();

        while (file.available() > 0)
        {
            int numb = file.read();
            if(numb % 2 == 0)
            {
                list.add(numb);
            }
        }

        reader.close();
        file.close();



        for(int x = 0;  x < list.size() - 1; x++)
        {
            for(int y = 0; y < list.size() - y - 1; y++)
            {
                if(list.get(y) > list.get(y+1))
                {
                    swap(list, y, y+1);
                }
            }
        }



    }

    public static  void swap(List<Integer> list, int x, int y)
    {
        int z = list.get(x);
        list.add(x,list.get(y));
        list.add(y, z);
    }
}
