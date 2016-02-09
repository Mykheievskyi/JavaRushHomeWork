package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level17.lesson10.bonus03.Table;
import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.util.List;

/**
 * Created by dima on 25.01.16.
 */
public class Order {
    private List<Dish> dishes;
    private Table table;

    public Order(Table table) throws IOException
    {
        this.table = table;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        if (dishes.size() == 0 || dishes.isEmpty())
            return "";
        else
            return "Your order: " + dishes.toString() + " of Tablet  " + table;
    }
}
