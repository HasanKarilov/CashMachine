package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

/**
 * Created by hanaria on 2/2/17.
 */
class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int moneyToTake;

        while(true)
        {
            try
            {
                ConsoleHelper.writeMessage("Count money you want");
                moneyToTake = Integer.parseInt(ConsoleHelper.readString());
            }
            catch (NumberFormatException e){
                ConsoleHelper.writeMessage("Money number format exception");
                continue;
            }
            if(moneyToTake <= 0){
                ConsoleHelper.writeMessage("Enter not empty value");
                continue;
            }
            if(!currencyManipulator.isAmountAvailable(moneyToTake))
            {
                    ConsoleHelper.writeMessage("Not enough money");
            }
            try
            {
                currencyManipulator.withdrawAmount(moneyToTake);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("exact amount not available");
                continue;
            }
            break;
        }
/*

 */
    }
}