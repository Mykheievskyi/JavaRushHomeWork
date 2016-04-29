package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by dima on 26.04.16.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y);
        this.setWidth(2);
        this.setHeight(2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.red);

        int xUpperLeftCorner = getX() - getWidth()/2;
        int yUpperLeftCorner = getY() - getHeight()/2;

        graphics.drawRect(xUpperLeftCorner, yUpperLeftCorner, getWidth(), getHeight());
        graphics.fillRect(xUpperLeftCorner, yUpperLeftCorner, getWidth(), getHeight());

    }
}
