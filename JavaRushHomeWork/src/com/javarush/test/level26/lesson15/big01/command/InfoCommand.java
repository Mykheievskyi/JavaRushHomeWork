package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by dima on 13.01.16.
 */
class InfoCommand implements Command
{
    @Override
    public void execute() {

        boolean moneyAvailable = false;
        for (CurrencyManipulator c : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (c.hasMoney()){
                if (c.getTotalAmount() > 0)
                {
                    ConsoleHelper.writeMessage(c.getCurrencyCode() + " - " + c.getTotalAmount());
                    moneyAvailable = true;
                }
            }
        }
        if (!moneyAvailable)
        {
            ConsoleHelper.writeMessage("No money available.");
        }

    }
}
