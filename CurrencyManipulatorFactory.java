package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by hanaria on 2/2/17.
 */
public class CurrencyManipulatorFactory
{
    private static final HashMap<String, CurrencyManipulator> manipulatorHashMap = new HashMap<String, CurrencyManipulator>();
    private CurrencyManipulatorFactory(){
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        CurrencyManipulator currencyManipulator;
        if(manipulatorHashMap.containsKey(currencyCode))
        {
            return manipulatorHashMap.get(currencyCode);
        }
        else
        {
            currencyManipulator = new CurrencyManipulator(currencyCode);
            manipulatorHashMap.put(currencyCode, currencyManipulator);

        return currencyManipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return  manipulatorHashMap.values();
    }

}