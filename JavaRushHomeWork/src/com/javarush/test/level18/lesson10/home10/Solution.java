package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;


public class Solution
{
    static Map<Integer, byte[]> map = new TreeMap<Integer, byte[]>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName;
        String finishFileName = "";

        while (!(fileName =reader.readLine()).equals("end"))
        {

            String[] name = fileName.split(".part");

            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            finishFileName =  name[0];
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            map.put(Integer.parseInt(name[1]),buffer);

            fileInputStream.close();
        }
        reader.close();

        File newFile = new File(finishFileName);
        if(!newFile.exists())      // если файла не существует, то создаем такой файл
            newFile.createNewFile();


        FileOutputStream fileOutputStream = new FileOutputStream(newFile);

        for(Map.Entry<Integer, byte[]> pair: map.entrySet())
        {
            fileOutputStream.write(pair.getValue());
            System.out.println(pair.getValue());
        }

        fileOutputStream.close();

    }
}