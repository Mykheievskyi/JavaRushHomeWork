package com.javarush.test.level08.lesson08.task01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();

        set.add("Ложь");
        set.add("Ложка");
        set.add("Лес");
        set.add("Лор");
        set.add("Лёывфыва");
        set.add("Лёхка");
        set.add("Лёхпа");
        set.add("Лёиха");
        set.add("Лёмха");
        set.add("Лёдха");
        set.add("Лёха");
        set.add("Лёяха");
        set.add("Лсёха");
        set.add("Лёчсха");
        set.add("Лёмсха");
        set.add("Лёчсмха");
        set.add("Лёчясмха");
        set.add("Лёчсмчсмха");
        set.add("Лёячсмячсмха");
        set.add("Лёчясмячсмячсмячсха");

        return set;
    }
}
