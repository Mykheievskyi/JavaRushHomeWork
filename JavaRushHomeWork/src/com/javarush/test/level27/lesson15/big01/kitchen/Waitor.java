package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administator on 04.11.2015.
 */
public class Waitor implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        Cook cook = (Cook) o;

        ConsoleHelper.writeMessage(order.toString() + " was cooked by " + cook.toString());
    }
}
