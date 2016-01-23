package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dima on 13.01.16.
 */
public class CommandExecutor
{
    private static Map<Operation, Command> map = new HashMap<>();

    public CommandExecutor() {}

    static
    {
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }


    public static final void execute(Operation operation) throws InterruptOperationException
    {
        map.get(operation).execute();
    }
}
