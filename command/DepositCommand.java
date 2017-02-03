package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by hanaria on 2/2/17.
 */
class DepositCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] nominalAndCount = ConsoleHelper.getValidTwoDigits(currencyCode);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        currencyManipulator.addAmount(Integer.parseInt(nominalAndCount[0]), Integer.parseInt(nominalAndCount[1]));
    }
}