package com.javarush.test.level14.lesson06.home01;

/**
 * Created by dima on 21.09.15.
 */
public class MoldovanHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return  34;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

    }
}
