package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/



import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        FileOutputStream file3 = new FileOutputStream(reader.readLine());

        byte[] buffer2 = new byte[file1.available() - file1.available() / 2 ];
        byte[] buffer3 = new byte[ file1.available()/2];

        file2.write(buffer2, 0, file1.read(buffer2));
        file3.write(buffer3, 0, file1.read(buffer3));

        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
