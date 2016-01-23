package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());

        FileInputStream in1 = new FileInputStream(file1);

        byte[] copy = new byte[in1.available()];

        while (in1.available() >0)
        {
            in1.read(copy);
        }
        in1.close();

        FileInputStream in2 = new FileInputStream(file2);

        byte[] buf2 = new byte[in2.available()];


        FileOutputStream in11 = new FileOutputStream(file1);



    }
}
