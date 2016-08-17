package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> fileList = new ArrayList<>();

        String fileName;

        while (!(fileName = br.readLine()).equalsIgnoreCase("exit"))
        {
                fileList.add(fileName);
        }

        for (String file: fileList)
        {
            new ReadThread(file).start();
        }

        br.close();
    }

    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName)
        {
            //implement constructor body
            this.fileName = fileName;
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        @Override
        public void run()
        {
            try {

                FileInputStream iStream = new FileInputStream(fileName);
                int max = Integer.MIN_VALUE;
                int result = Integer.MIN_VALUE;

                while (iStream.available() > 0) {
                    int data = iStream.read();
                    if (countMap.containsKey(data)) {
                        countMap.put(data, countMap.get(data) + 1);
                    }
                    else {
                        countMap.put(data, 1);
                    }
                }
                iStream.close();

                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        result = entry.getKey();
                    }
                }

                synchronized (resultMap) {
                    resultMap.put(this.fileName, result);
                }
            } catch (Exception e) {}
        }
    }
}
