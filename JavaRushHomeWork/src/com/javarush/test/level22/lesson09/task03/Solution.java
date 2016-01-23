package com.javarush.test.level22.lesson09.task03;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(new File(reader.readLine()));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder text = new StringBuilder();
        while (bufferedReader.ready())
        {
            text.append(bufferedReader.readLine()).append(" ");
        }
        reader.close();
        fileReader.close();
        bufferedReader.close();

        String [] words = text.toString().split(" ");

        StringBuilder result = getLine(words);

        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        ArrayList<String> wordsList = new ArrayList<>();
        Collections.addAll(wordsList,words);

        StringBuilder result = new StringBuilder();

        result.append(wordsList.get(0));
        wordsList.remove(0);

        while (wordsList.size() > 0)
        {
            for (int i = 0; i < wordsList.size(); i++)
            {
                String a = result.toString().toUpperCase().toLowerCase();
                String b = wordsList.get(i).toUpperCase().toLowerCase();

                if (a.charAt(a.length() - 1) == b.charAt(0))
                {
                    result.append(" ").append(wordsList.get(i));
                    wordsList.remove(i);
                    continue;
                }

                if (a.charAt(0) == b.charAt(b.length() - 1))
                {
                    result.insert(0," ");
                    result.insert(0, wordsList.get(i));
                    wordsList.remove(i);
                }
            }
        }
          return result;
    }
}
