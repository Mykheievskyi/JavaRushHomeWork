package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administator on 04.11.2015.
 */
public class Order {
    Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) return "";
        else {
            String result = "Your order: " + dishes.toString() + " of " + tablet.toString();
            return result;
        }
    }

    public int getTotalCookingTime() {
        int result = 0;
        for (Dish dish : dishes)
            result += dish.getDuration();
        return result;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
