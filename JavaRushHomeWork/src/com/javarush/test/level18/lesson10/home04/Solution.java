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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String file1 = br.readLine();
        String file2 = br.readLine();

        br.close();

        RandomAccessFile rafFiles1 = new RandomAccessFile(file1, "rw");
        RandomAccessFile rafFiles2 = new RandomAccessFile(file2, "r");

        //создаем буфер для первого файла и считываем в него первый файл
        byte[] bufferFile1 = new byte[(int) rafFiles1.length()];
        rafFiles1.read(bufferFile1);

        //создаем буфер для второго файла и считываем в него второй файл
        byte[] bufferFile2 = new byte[(int) rafFiles2.length()];
        rafFiles2.read(bufferFile2);

        //устанавливаем курсор на нулевую позицию в файле
        rafFiles1.seek(0);

        rafFiles1.write(bufferFile2);
        rafFiles1.write(bufferFile1);

        rafFiles1.close();
        rafFiles2.close();

    }
}
