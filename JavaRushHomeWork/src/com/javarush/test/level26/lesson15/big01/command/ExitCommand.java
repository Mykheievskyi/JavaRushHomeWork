package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.ResourceBundle;


/**
 * Created by dima on 13.01.16.
 */
class ExitCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en");

    @Override
    public void execute() throws  InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String answer = ConsoleHelper.readString().trim();

        if (answer.equalsIgnoreCase(res.getString("yes")))
        {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}
