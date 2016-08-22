package com.javarush.test.level36.lesson08.task01;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {

        Set<String> treeSet = new TreeSet<>();


        String [] chars = readFile(args[0]).split("");

        for (int i = 0; i < chars.length; i++)
        {
            // "\\w" - любая буква или цифра, "\\D" - любой нецифровой символ
            if (chars[i].matches("\\w") && chars[i].matches("\\D"))
            {
                treeSet.add(chars[i]);
            }
        }

        Iterator iterator = treeSet.iterator();;
        int temp;

        if (treeSet.size() < 5)
        {
            temp = treeSet.size();
        }
        else
        {
            temp = 5;
        }


        for (int i = 0; i < temp; i++)
        {
            System.out.print(iterator.next());
            iterator.hasNext();
        }

    }

    public static String readFile(String pathToFile) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(new File(pathToFile)));

        StringBuilder text = new StringBuilder();

        while (br.ready())
        {
            text.append(br.readLine().toLowerCase());
        }


        br.close();

        return text.toString();
    }
}
