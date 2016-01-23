package com.javarush.test.level08.lesson08.task02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < 20; i++)
        {
            set.add(i);
        }
        return set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(set);

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) > 10)
            {
                list.remove(i);
                i--;
            }
        }

        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.addAll(list);

        return hashSet;
    }
}
