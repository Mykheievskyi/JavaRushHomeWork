package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


/**
 * Created by dima on 13.01.16.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Do you really want to exit? <y,n>");

        if (ConsoleHelper.readString().equals("y"));
            ConsoleHelper.writeMessage("Thank you for visiting JavaRush cash machine. Good luck.");
    }
}
