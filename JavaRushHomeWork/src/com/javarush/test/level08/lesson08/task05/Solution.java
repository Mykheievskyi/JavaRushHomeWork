package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Сметанина", "Анна");
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        for(Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getValue();
            removeItemFromMapByValue(map, value);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
