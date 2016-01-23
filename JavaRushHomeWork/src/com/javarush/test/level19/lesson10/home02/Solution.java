package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> lines = new TreeMap<String, Double>();

        while (bufferedReader.ready())
        {
            String[] line = bufferedReader.readLine().split(" ");
            String name = line[0];
            double cash = Double.parseDouble(line[1]);

            if(lines.containsKey(name))
            {
                lines.put(name, lines.get(name) + cash);
            }
            else {lines.put(name, cash);}
        }

        String richBitch = "";
        double rich = 0;

        for( Map.Entry<String, Double> pair : lines.entrySet() )
        {
            if(pair.getValue() > rich)
            {
                richBitch = pair.getKey();
            }
        }
        System.out.println(richBitch);


        bufferedReader.close();
    }
}
