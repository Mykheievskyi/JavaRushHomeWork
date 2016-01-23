package com.javarush.test.level14.lesson06.home01;

/**
 * Created by dima on 21.09.15.
 */
public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return  345;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

    }
}
