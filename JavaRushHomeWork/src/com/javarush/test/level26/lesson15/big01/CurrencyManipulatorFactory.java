package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by dima on 07.01.16.
 */
public class CurrencyManipulatorFactory
{
    private static HashMap<String, CurrencyManipulator> manipulators = new HashMap<>();

    private CurrencyManipulatorFactory()
    {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (!manipulators.containsKey(currencyCode)) {
            manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
            return manipulators.get(currencyCode);
        }
        else
        {
            CurrencyManipulator cur = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode, cur);
            return cur;
        }
    }

   public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
   {
        return manipulators.values();
    }
}
