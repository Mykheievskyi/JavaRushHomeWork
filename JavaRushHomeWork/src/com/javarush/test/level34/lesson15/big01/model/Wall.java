package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by dima on 26.04.16.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.darkGray);

        int xUpperLeftCorner = getX() - getWidth()/2;
        int yUpperLeftCorner = getY() - getHeight()/2;

        graphics.drawRect(xUpperLeftCorner, yUpperLeftCorner, getWidth(), getHeight());
        graphics.fillRect(xUpperLeftCorner, yUpperLeftCorner, getWidth(), getHeight());

    }
}
