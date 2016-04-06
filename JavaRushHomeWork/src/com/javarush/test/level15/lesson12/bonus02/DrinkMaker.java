package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by dima on 31.03.16.
 */
abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    public void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
