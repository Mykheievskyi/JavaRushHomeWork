package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prop = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        InputStream fileProperties = new FileInputStream(br.readLine());

        br.close();

        load(fileProperties);
        fileProperties.close();

    }

    public void save(OutputStream outputStream) throws Exception
    {
        //implement this method - реализуйте этот метод

        if (prop.size() > 0)
        {
            prop.putAll(properties);
        }

        prop.store(outputStream, "");

    }

    public void load(InputStream inputStream) throws Exception
    {
        //implement this method - реализуйте этот метод

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        prop.load(inputStream);

        Set<String> list = prop.stringPropertyNames();

        for (String currently : list)
        {
            properties.put(currently, prop.getProperty(currently));
        }
    }

}
