package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by dima on 21.04.16.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    @Override
    public void execute() throws InterruptOperationException
    {
        String cardNumber;
        String pin;

        while (true)
        {
            ConsoleHelper.writeMessage("Введите два числа номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр");
            cardNumber = ConsoleHelper.readString();
            pin = ConsoleHelper.readString();

            if (validCreditCards.containsKey(cardNumber))
            {
                if (validCreditCards.getString(cardNumber).equals(pin))
                {
                    ConsoleHelper.writeMessage("верификация прошла успешно");
                    break;
                }
                else
                {
                    ConsoleHelper.writeMessage("не верные данные");
                    ConsoleHelper.writeMessage("попробуйте еще раз ввести пин кредитной карты");
                }
            }
            else
            {
                ConsoleHelper.writeMessage("не верные данные");
                ConsoleHelper.writeMessage("попробуйте еще раз ввести номер кредитной карты");
            }
        }
    }
}
