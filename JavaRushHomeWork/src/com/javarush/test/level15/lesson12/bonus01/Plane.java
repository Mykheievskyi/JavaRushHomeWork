package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by dima on 31.03.16.
 */
public class Plane implements Flyable
{
    private int numberPassengers;

    public Plane(int numberPassengers)
    {
        this.numberPassengers = numberPassengers;
    }

    @Override
    public void fly() {

    }
}
