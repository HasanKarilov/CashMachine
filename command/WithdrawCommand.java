package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

/**
 * Created by hanaria on 2/2/17.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currency = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int moneyToTake;

        while(true)
        {
            try
            {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                moneyToTake = Integer.parseInt(ConsoleHelper.readString());
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), moneyToTake,currencyCode));
            }
            catch (NumberFormatException e){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if(moneyToTake <= 0){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if(!currency.isAmountAvailable(moneyToTake))
            {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
            try
            {
                currency.withdrawAmount(moneyToTake);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            break;
        }
/*

 */
    }
}