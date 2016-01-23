package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id,
 найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();



        FileWriter fileWriter = new FileWriter(new File(fileName));
        String line;

        while (!(line = reader.readLine()).equals("end"));
        {
            String[] text = line.split(" ");
            if(text[0].equals("-c"))
            {
                String num = getID(fileName)+1;

                char[] id = new char[8];
                char[] name = new char[30];
                char[] price = new char[8];
                char[] quantity = new char[4];

                id = num.toCharArray();
                name = text[1].toCharArray();
                price = text[2].toCharArray();
                quantity = text[3].toCharArray();

                fileWriter.write(id.toString() + name.toString() + price.toString() + quantity.toString());
            }

        }
    }

    public static  String  getID(String fileName) throws IOException
    {
        FileReader fileReader = new FileReader(new File(fileName));

        BufferedReader line = new BufferedReader(fileReader);
        int ID = 0, nextID = 0;

        while (line.ready())
        {
            int id = Integer.parseInt(line.readLine().substring(0, 7));
            if(ID < id) ID = id;
        }
        nextID  = ID + 1;

        line.close();

        return Integer.toString(nextID);
    }
}
