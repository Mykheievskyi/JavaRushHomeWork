package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String>  map = new HashMap<String, String>();

        map.put("Сметанна", "Анна");
        map.put("Сталлоне","Сильвестр");
        map.put("Ван дам", "Жанклод");
        map.put("Шварц", "Арнольд");
        map.put("Чан", "Джеки");
        map.put("Вилис", "Смит");
        map.put("Норрис", "Чак");
        map.put("Лунгрен", "Адам");
        map.put("Стэтхэм", "Адре");
        map.put("Бандэрос ", "Сибастьян");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;

        for (String tmp : map.values())
        {
            if (name.equals(tmp))
            {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        return map.containsKey(familiya) ? 1 : 0;
    }
}
