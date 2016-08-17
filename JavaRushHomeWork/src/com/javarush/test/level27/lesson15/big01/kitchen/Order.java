package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;
import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.util.List;

/**
 * Created by dima on 25.01.16.
 */
public class Order
{
    private List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        else {
            return "Your order: " + dishes.toString() +" of "+  tablet.toString();
        }

    }

    public int getTotalCookingTime()
    {
        int time = 0;
        for (Dish dish: dishes)
        {
            time += dish.getDuration();
        }
        return time;
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }

    public Tablet getTablet() {
        return tablet;
    }
}
