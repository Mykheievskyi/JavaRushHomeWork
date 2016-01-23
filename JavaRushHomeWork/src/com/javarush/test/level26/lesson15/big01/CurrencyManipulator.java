package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dima on 07.01.16.
 */
public class CurrencyManipulator
{

    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();


    public String getCurrencyCode()
    {
        return currencyCode;
    }


    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount()
    {
        int totalAmount = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            totalAmount += entry.getKey() * entry.getValue();
        }
        return totalAmount;
    }

    public boolean hasMoney()
    {
        return !denominations.isEmpty();
    }
}
