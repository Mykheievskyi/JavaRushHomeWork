package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));

        List<String> list = new ArrayList<String>();

        while (bufferedReader.ready())
        {
            String[] line = bufferedReader.readLine().split(" ");

            for(int i = 0; i < line.length; i++)
            {
                if(line[i].length() > 6)
                {
                    list.add(line[i]);
                }
            }
        }

        for(int i = 0; i < list.size()-1; i++)
        {
            bufferedWriter.write(list.get(i) + ",");
        }
        bufferedWriter.write(list.get(list.size()-1));

        bufferedReader.close();
        bufferedWriter.close();
    }
}
