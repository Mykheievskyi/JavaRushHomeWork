package com.javarush.test.level08.lesson06.task01;

import java.awt.*;
import java.util.*;
import java.util.List;

/* Создать два списка LinkedList и ArrayList
Нужно создать два списка – LinkedList и ArrayList.
*/

public class Solution
{
    public static Object createArrayList()
    {
        List<String>  list = new ArrayList<String>();
        return  list;
    }

    public static Object createLinkedList()
    {
        List<String> map = new LinkedList<String>();
        return  map;

    }
}
