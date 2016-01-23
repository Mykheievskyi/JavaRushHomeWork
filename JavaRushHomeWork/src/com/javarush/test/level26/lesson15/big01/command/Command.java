package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by dima on 13.01.16.
 */
interface Command
{
    void execute()throws InterruptOperationException;
}
