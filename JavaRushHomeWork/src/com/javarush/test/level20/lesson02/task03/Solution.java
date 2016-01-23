package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<String,String>();

    public void fillInPropertiesMap()   throws IOException
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(new File(reader.readLine()));

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            String  text = "";
            if(!line.startsWith("#") && !line.startsWith("!"))
            {
                char[] charLine = new char[line.length()];
                for(int i = 0; i < line.length(); i++)
                {
                    text += charLine[i];
                    if(charLine[i] == '=' && charLine[i] == ' ' && charLine[i] == ':')
                    {
                        
                    }
                }
            }
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }
}
