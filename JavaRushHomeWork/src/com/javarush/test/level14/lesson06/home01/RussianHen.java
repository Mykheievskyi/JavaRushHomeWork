package com.javarush.test.level14.lesson06.home01;

/**
 * Created by dima on 20.09.15.
 */
public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return  5;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
