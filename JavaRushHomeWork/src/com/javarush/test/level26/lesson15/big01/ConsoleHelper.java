package com.javarush.test.level26.lesson15.big01;



import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by dima on 07.01.16.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String message = "";

            try
            {
                message = consoleReader.readLine();
                if (message.equalsIgnoreCase(res.getString("operation.EXIT")))
                {
                    throw new InterruptOperationException();
                }
            }
            catch (IOException e) {}

            return message;
    }


    public static String askCurrencyCode() throws InterruptOperationException
    {
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String str = readString();
            if (str.length() != 3) {
                writeMessage(res.getString("invalid.data"));
            } else {
                return str.toUpperCase();
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

        writeMessage(res.getString("choose.denomination.and.count.format"));

        while (true)
        {
            String[] answer = readString().split(" ");
            try {
                if (answer.length == 2 && Integer.parseInt(answer[0]) >= 0 && Integer.parseInt(answer[1]) >= 0) {
                    return answer;
                } else {
                    writeMessage(res.getString("invalid.data"));
                }
            }catch (NumberFormatException ex)
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {

        writeMessage("Выберете команду: 1 — INFO, 2 — DEPOSIT, 3 — WITHDRAW, 4 — EXIT");

        while (true)
        {
            int temp = Integer.parseInt(readString());
            if (1 <= temp || temp <= 4)
            {
                return Operation.getAllowableOperationByOrdinal(temp);
            }
            else
                writeMessage(res.getString("invalid.data"));
        }
    }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
