package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        while(!(fileName = reader.readLine()).equals("exit"))
        {
            new ReadThread(fileName).start();
            fileName = reader.readLine();
        }
        reader.close();
    }

    public static class ReadThread extends Thread
    {

        private String fileName;

        public ReadThread( String fileName)
        {
            this.fileName = fileName;
        }



        @Override
        public void run()
        {
            try
            {
                FileInputStream in = new FileInputStream(fileName);
                byte[] bytes = new byte[in.available()];
                in.read(bytes);

                int[] integer = new int[256];


                for(int i = 0; i < bytes.length; i++)
                {
                    integer[bytes[i]]++;
                }

                int count = 0;
                int value = 0;

                for(int i = 0; i < 256; i++)
                {
                    if (count < integer[i])
                    {
                        count = integer[i];
                        value= i;
                    }
                    Solution.resultMap.put(fileName,value);
                }
                in.close();

            }catch (IOException e){}
        }
    }
}
