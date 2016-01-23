package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)  throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream file1 = new FileInputStream(reader.readLine());

        byte[] buffer = new byte[file1.available()];

        file1.read(buffer);


        FileOutputStream file2 = new FileOutputStream(reader.readLine());

        for (int i = 0; i < buffer.length; i++)
        {
            if((i+1) % 2 == 0 )
            {
                file2.write(buffer[i]);
            }
        }

        reader.close();
        file1.close();
        file2.close();
    }
}
