package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by dima on 13.01.16.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));


        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] denominations = new String[0];

        try {
            denominations = ConsoleHelper.getValidTwoDigits(currencyCode);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), currencyCode));
        }
        catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }

        int denomination = Integer.parseInt(denominations[0]);
        int count = Integer.parseInt(denominations[1]);

        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).addAmount(denomination,count);
    }
}