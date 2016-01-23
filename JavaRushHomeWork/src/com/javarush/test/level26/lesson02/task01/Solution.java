package com.javarush.test.level26.lesson02.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {

        Arrays.sort(array);

        final double median;
        if (array.length % 2 == 0)
        {
            median = (array[array.length/2 - 1] + array[array.length/2])/2;
        }
        else
            median = array[array.length/2];


        Comparator<Integer> comparatorByMedian = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double result = Math.abs(o1 - median) - Math.abs(o2 - median);
                if (result == 0)
                    result = o1 - o2;
                return (int) result;
            }
        };

        Arrays.sort(array,comparatorByMedian);
        

        //implement logic here
        return array;
    }
}
