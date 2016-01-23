package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        List<String> words = new ArrayList<>();

        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileReader file = new FileReader(new File(reader.readLine()));
                BufferedReader line = new BufferedReader(file)
        )
        {
            StringBuilder text = new StringBuilder("");

            while (line.ready())
            {
                text.append(line.readLine()).append(" ");
            }

             words.addAll(Arrays.asList(text.toString().split(" ")));

            for(int i = 0; i < words.size(); i ++)
            {
                for(int j = 0; j < words.size();)
                {
                    if(words.get(i).equals(new StringBuilder(words.get(j)).reverse().toString()) && j != i)
                    {
                      Pair pair = new Pair();

                        pair.first = words.get(i);
                        pair.second = words.get(j);
                        result.add(pair);
                        words.remove(j);
                        words.remove(i);
                        j = 0;

                    }
                    else
                        j++;
                }
            }

        }



    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
