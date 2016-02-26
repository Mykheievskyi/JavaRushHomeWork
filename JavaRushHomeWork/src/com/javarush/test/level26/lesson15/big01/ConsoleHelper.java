package com.javarush.test.level26.lesson15.big01;



import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dima on 07.01.16.
 */
public class ConsoleHelper
{

    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String message = null;

            try {
                message = consoleReader.readLine();
            }
            catch (IOException e) {}

            if ("exit".equalsIgnoreCase(message.trim()))
            {
                throw new InterruptOperationException();
            }

            return message;
    }


    public static String askCurrencyCode() throws InterruptOperationException
    {
        while (true) {
            writeMessage("Введите код валюты: ");
            String str = readString();
            if (str.length() != 3) {
                writeMessage("Неверный код валюты! Введите заново.");
            } else {
                return str.toUpperCase();
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            writeMessage("Введите два целых положительных числа. Первое - номинал, второе - количество банкнот: ");

            String[] answer = readString().split(" ");
            try {
                if (answer.length == 2 && Integer.parseInt(answer[0]) >= 0 && Integer.parseInt(answer[1]) >= 0) {
                    return answer;
                } else {
                    writeMessage("Введены неверные данные, повторите ввод!");
                }
            }catch (NumberFormatException ex)
            {
                writeMessage("Введены неверные данные, повторите ввод!");
            }
        }
    }

    public static Operation askOperation()
    {
        writeMessage("Выберете команду: 1 — INFO, 2 — DEPOSIT, 3 — WITHDRAW, 4 — EXIT");
        try
        {
            int temp = Integer.parseInt(consoleReader.readLine());
            return Operation.getAllowableOperationByOrdinal(temp);
        }
        catch (Exception e)
        {
            return askOperation();
        }
    }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage("Terminated. Thank you for visiting JavaRush cash machine. Good luck.");
    }
}
