package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by dima on 25.04.16.
 */
public class Cook extends Observable implements Observer
{
    private final String name;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }


    @Override
    public void update(Observable observable, Object arg)
    {
        if (arg instanceof  Order)
        {
            Order order = (Order) arg;
            ConsoleHelper.writeMessage("Start cooking - "+order+", cooking time "+order.getTotalCookingTime()+"min");


            setChanged();
            notifyObservers(order);
        }
    }


}
