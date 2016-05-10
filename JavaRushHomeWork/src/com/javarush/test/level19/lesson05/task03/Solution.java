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

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileSource = br.readLine();
        String fileSave = br.readLine();

        BufferedReader file = new BufferedReader(new FileReader(new File(fileSource)));
        StringBuilder result = new StringBuilder("");

        while (file.ready())
        {
            String [] fileLine = file.readLine().split(" ");

            for (int i = 0; i < fileLine.length; i++)
            {
                if(isNumber(fileLine[i]))
                {
                   result.append(fileLine[i] + " ");
                }
            }
        }

        //записываем строку результата в файл
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileSave)));

        bw.write(result.toString());

        br.close();
        file.close();
        bw.close();

    }

    //метод проверяет является ли строка числом
    public static boolean isNumber(String str)
    {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
