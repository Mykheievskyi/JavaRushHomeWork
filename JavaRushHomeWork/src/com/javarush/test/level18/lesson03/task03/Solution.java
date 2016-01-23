package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        int[] bytesArray = new int[256];

        while (file.available() > 0)
        {
            int currentByte = file.read();
            bytesArray[currentByte]++;
        }

        int max = 0;

        for(int i = 0; i < bytesArray.length; i++)
        {
            if (bytesArray[i] > max)
            {
                max = bytesArray[i];
            }
        }

        for(int x = 0; x < bytesArray.length; x++)
        {
            if(bytesArray[x] == max)
                System.out.print(x + " ");
        }

        reader.close();
        file.close();

    }
}
