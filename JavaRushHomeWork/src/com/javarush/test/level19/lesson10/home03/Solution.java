package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args)
    {
        try {
            String fileName = args[0];

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            while (reader.ready())
            {
                Date date = new Date();
                String personName = "";
                String[] line = reader.readLine().split(" ");

                for(int i = 0; i < line.length; i++)
                {
                    try
                    {
                        date = new SimpleDateFormat("dd MM yyyy").parse(line[i] + " " + line[i+1] + " " +line[i+2] + " ");
                        break;
                    } catch (ParseException e)
                    {
                        personName = personName + line[i] + " ";
                    }
                }

                personName = removeLastChar(personName);

                PEOPLE.add(new Person(personName, date));
            }

            reader.close();

        } catch(IOException e) {}



    }

    public static String removeLastChar(String s)
    {
        if (s == null || s.length() == 0)
        {
            return s;
        }
        return s.substring(0,s.length() - 1);
    }

}
