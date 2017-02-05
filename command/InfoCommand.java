package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by hanaria on 2/2/17.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute()
    {
        boolean isEmpty = false;
        ConsoleHelper.writeMessage(res.getString("before"));
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
        if(!isEmpty)
        {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}