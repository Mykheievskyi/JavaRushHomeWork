package com.javarush.test.level14.lesson08.home02;

/**
 * Created by dima on 20.09.15.
 */
public class Wine extends Drink
{
    public String getHolidayName()
    {
        return "День рождения";
    }

    /**
     * Created by dima on 20.09.15.
     */
    public abstract static class Drink
    {
        public void taste()
        {
            System.out.println("Вкусно");
        }
    }
}
