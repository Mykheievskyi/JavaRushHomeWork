package com.javarush.test.level21.lesson16.big01;

/**
 * Created by dima on 02.12.15.
 */
public class Horse {

    public String name;
    public double speed;
    public double distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move()
    {
        speed *= Math.random()*1.5;
        distance += speed;
    }

    public void print()
    {
        for(int i = 0; i <  distance; i++)
        {
            System.out.print(".");
        }
        System.out.print(name);
    }
}
