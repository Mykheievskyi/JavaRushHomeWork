package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by dima on 13.01.16.
 */
class DepositCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();

        String[] denominations = ConsoleHelper.getValidTwoDigits(currencyCode);
        int denomination = Integer.parseInt(denominations[0]);
        int count = Integer.parseInt(denominations[1]);

        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).addAmount(denomination,count);
    }
}