package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by hanaria on 2/2/17.
 */
class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        boolean isEmpty = false;
        for(CurrencyManipulator currencyManipulator: CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (currencyManipulator.hasMoney()){
                if (currencyManipulator.getTotalAmount() > 0)
                {
                    ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
                    isEmpty = true;
                }
            }
        }
        if(!isEmpty){
            ConsoleHelper.writeMessage("No money available.");
        }
    }
}