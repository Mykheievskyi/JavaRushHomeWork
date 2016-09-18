package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Administator on 04.11.2015.
 */
public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int i) {
        duration = i;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder result = new StringBuilder();
        for (Dish dish : Dish.values()) {
            result.append(dish.toString() + ", ");
        }
        return result.toString().substring(0, result.toString().length() - 2);
    }
}
