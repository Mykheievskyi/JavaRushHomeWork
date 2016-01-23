package com.javarush.test.level05.lesson12.home04;

import java.util.Calendar;



/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

public class Solution
{
    public static void main(String[] args)
    {
        Calendar rightNow = Calendar.getInstance();

        int year = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        int day = rightNow.get(Calendar.DAY_OF_MONTH);

        System.out.println(day + " 0" + (month+1) + " " + year);
    }
}
