package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());

        String text = "";
        char  currentChar;

        while (fileReader.ready())
        {
            currentChar = (char) fileReader.read();
            text = text + currentChar;
        }

        String[] words = text.split(" ");

        for(int m = 0; m < words.length; m++)
        {
            char[] chars = words[m].toCharArray();
            int count = 0;
            System.out.println(words[m]);

            for (int n = 0; n < chars.length; n++)
            {
                System.out.print(chars[n] + " ");

                if(chars[n]>= '0' && chars[n] <= '9') {count++;}
            }
            System.out.println("");
            if(count == chars.length)
            {
                String s = words[m] + " ";
                fileWriter.write(s);
            }
        }

        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
