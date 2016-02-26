package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;


/**
 * Created by dima on 13.01.16.
 */
class ExitCommand implements Command
{


    @Override
    public void execute() throws  InterruptOperationException
    {
        ConsoleHelper.writeMessage("Do you really want to exit? <y,n>");
        String answer = ConsoleHelper.readString().trim();

        if (answer.equalsIgnoreCase("y"))
        {
            ConsoleHelper.writeMessage("Thank you for visiting JavaRush cash machine. Good luck.");
        }
    }
}
