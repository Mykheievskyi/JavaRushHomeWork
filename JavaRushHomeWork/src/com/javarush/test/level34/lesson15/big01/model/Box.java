package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by dima on 26.04.16.
 */
public class Box extends CollisionObject implements Movable
{
    public Box(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.blue);
        int xUpperLeftCorner = getX() - getWidth()/2;
        int yUpperLeftCorner = getY() - getHeight()/2;
        graphics.drawRect(xUpperLeftCorner, yUpperLeftCorner, getWidth(), getHeight());
        graphics.fillRect(xUpperLeftCorner, yUpperLeftCorner, getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y)
    {
        this.setX(getX()+x);
        this.setY(getY()+y);
    }
}
