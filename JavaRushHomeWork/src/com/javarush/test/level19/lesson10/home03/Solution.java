package com.javarush.test.level19.lesson10.home03;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

    public static void main(String[] args) throws IOException
    {
        BufferedReader rd = new BufferedReader(new FileReader(args[0]));

        String[] symbols;
        int sizeSymbols;
        String personName;
        Date personDate;

        while (rd.ready()) {
            symbols = rd.readLine().split(" ");
            sizeSymbols = symbols.length;
            personDate = new Date(Integer.parseInt(symbols[sizeSymbols - 1]), Integer.parseInt(symbols[sizeSymbols - 2]), Integer.parseInt(symbols[sizeSymbols - 3]));
            personName = getName(symbols, sizeSymbols - 4);
            System.out.println(personName + "       " + personDate);
            PEOPLE.add(new Person(personName, personDate));

        }

        rd.close();

    }

    public static String getName(String[] args, int index) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            res.append(args[i]).append(" ");
        }

        return  res.toString();

    }

}
