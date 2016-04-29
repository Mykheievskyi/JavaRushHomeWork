package com.javarush.test.level34.lesson15.big01.model;


import java.awt.*;

/**
 * Created by dima on 26.04.16.
 */
public class Player extends CollisionObject implements Movable
{
    public Player(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void move(int x, int y)
    {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.yellow);

        int xUpperLeftCorner = getX() - getWidth()/2;
        int yUpperLeftCorner = getY() - getHeight()/2;

        graphics.drawOval(xUpperLeftCorner, yUpperLeftCorner, getWidth(), getHeight());
        graphics.fillOval(xUpperLeftCorner, yUpperLeftCorner,getWidth(),getHeight());

    }
}
