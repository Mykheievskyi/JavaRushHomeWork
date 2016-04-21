package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by dima on 13.01.16.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute()
    {

        boolean moneyAvailable = false;

        ConsoleHelper.writeMessage(res.getString("before"));

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
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }

    }
}
