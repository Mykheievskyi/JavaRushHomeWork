package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    static  int count = 0;
    static  String text = "";

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader file = new FileReader(reader.readLine());


        char currentChar;
        while (file.ready())
        {
            currentChar = (char) file.read();
            text = text + currentChar;
        }

        String replacedString = text.replaceAll("\\p{P}"," ").toLowerCase();
        replacedString=replacedString.replaceAll("\\s"," ");

        String splitString[] = replacedString.split(" ");
        for (String x : splitString) {
            if (x.equals("world")) {
                count++;
            }
        }

        System.out.println(count);
        reader.close();
        file.close();
    }
}
