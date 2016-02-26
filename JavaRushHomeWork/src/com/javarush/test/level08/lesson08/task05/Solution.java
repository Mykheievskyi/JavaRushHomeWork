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
        //напишите тут ваш код

        HashMap<String, String> map = new HashMap<>();


        map.put("Фамилия", "Имя");
        map.put("Фамилия1", "Имя");
        map.put("Фамилия2", "Имя1");
        map.put("Фамилия3", "Имя2");
        map.put("Фамилия4", "Имя3");
        map.put("Фамилия5", "Имя4");
        map.put("Фамилия6", "Имя5");
        map.put("Фамилия7", "Имя6");
        map.put("Фамилия8", "Имя7");
        map.put("Фамилия9", "Имя8");


        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код

        HashMap<String, String> duplicate = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair1: duplicate.entrySet()) {
            int count = 0;
            for (Map.Entry<String, String> pair2: duplicate.entrySet()) {
                if (pair1.getValue().equals(pair2.getValue())) {
                    count++;
                }
                if (count > 1) {
                    removeItemFromMapByValue(map, pair1.getValue());
                }
            }
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
