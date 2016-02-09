package com.javarush.test.level27.lesson15.big01;



import java.util.logging.Logger;

import static java.util.logging.Level.*;

/**
 * Created by dima on 25.01.16.
 */
public class Tablet
{
    final static  Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;

    public Tablet(int number)
    {
        this.number = number;
    }


    public void createOrder()
    {
        try
        {

        } catch (Exception e)
        {
            logger.log(SEVERE, "Console is unavailable.");
        }
    }


}
