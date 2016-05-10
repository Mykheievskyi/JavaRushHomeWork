package com.javarush.test.level19.lesson10.home03;

import java.io.*;
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

    public static void main(String[] args) throws IOException, ParseException
    {
        BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));

        while (br.ready())
        {


            String [] fileLine = br.readLine().split("");
            int size = fileLine.length;

            String name = "";


            Date date = new SimpleDateFormat("dd MM yyyy").parse(fileLine[size-3] + "-" + fileLine[size-2] + "-" + fileLine[size-1]);
            for (int i = 0; i < size - 3; i++)
            {
                name += fileLine[i];
            }

            PEOPLE.add(new Person(name, date));
        }

        br.close();

    }

}
