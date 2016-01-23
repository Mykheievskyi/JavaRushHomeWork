package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by dima on 07.01.16.
 */
public class CashMachine
{
    public static void main(String[] args)
    {

        Locale.setDefault(Locale.ENGLISH);

        try {
            Operation operation;

            do {

                operation = ConsoleHelper.askOperation();

                CommandExecutor.execute(operation);
            }
            while (operation != Operation.EXIT);
        } catch (InterruptOperationException e)
        {
            try {
                CommandExecutor.execute(Operation.EXIT);
            } catch (InterruptOperationException ignore){}
        }
    }

}
