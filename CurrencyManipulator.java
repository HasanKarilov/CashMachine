package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanaria on 2/2/17.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else denominations.put(denomination, count);
    }
    public int getTotalAmount(){
        int total = 0;
        for(Map.Entry<Integer, Integer> map: denominations.entrySet())
        {
            total = total + (map.getKey() * map.getValue());
        }
        return total;
    }
    public boolean hasMoney(){
        return denominations.size() != 0;
    }
}