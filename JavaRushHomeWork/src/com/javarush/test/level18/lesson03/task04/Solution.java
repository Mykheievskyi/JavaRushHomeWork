package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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

        int min = bytesArray[0];

        for (int i = 1; i < bytesArray.length; i++)
        {
            if(min > bytesArray[i])
            {
                min = bytesArray[i];
            }
        }


        for(int i = 0; i < bytesArray.length; i++)
        {
            if(bytesArray[i] == min)
            {
                System.out.print(min + " ");
            }
        }

        reader.close();
        file.close();

    }
}
