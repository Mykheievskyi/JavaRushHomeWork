package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 3)
        {
            throw new IllegalArgumentException();
        }

        FileInputStream fileRead = new FileInputStream(args[1]);
        byte[] buffer = new byte[fileRead.available()];
        fileRead.read(buffer);
        fileRead.close();

        byte[] result = new byte[0];

        if(args[0].equals("-e"))
        {
            result = encryption(buffer);
        }
        else if (args[0].equals("-d"))
        {
            result = decription(buffer);
        }


        FileOutputStream fileWriter = new FileOutputStream(args[2]);


        fileWriter.write(result);
        fileWriter.close();
    }

    public static byte[] encryption(byte[] data)
    {
        String sKey = "myKey";
        byte[] key = sKey.getBytes(); //
        byte[] result = new byte[data.length];

        for(int i = 0; i < data.length; i++)
        {
            result[i] = (byte) (data[i] ^ key[i % key.length]);
        }
        return result;
    }

    public static byte[] decription(byte[] data)
    {
        String sKey = "myKey";
        byte[] key = sKey.getBytes();
        byte[] result = new byte[data.length];

        for(int i = 0; i < data.length; i++)
        {
            result[i] = (byte) (data[i] ^ key[i % key.length]);
        }
        return result;
    }


}
