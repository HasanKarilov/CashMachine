package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created by hanaria on 2/5/17.
 */
public class LoginCommand implements Command
{
    /*
     CashMachine.RESOURCE_PATH - путь к файлу verifiedCards - название файла
     Когда getBundle метод определяет местоположение корректного файла свойств, он возвращает a PropertyResourceBundle объект,
     содержащий пары ключ/значение от файла свойств.
     */
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private String card, pin;

    @Override
    public void execute() throws InterruptOperationException
    {
        while (true)
        {
            try
            {
                ConsoleHelper.writeMessage("Input credit card number");
                card = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("Input credit card pin code");
                pin = ConsoleHelper.readString();
            }
            catch (IllegalArgumentException e){

            }
            if(validCreditCards.containsKey(card))
            {
                if(validCreditCards.getString(card).equals(pin))
                {
                    ConsoleHelper.writeMessage("Verification success!");
                    break;
                }
            }

            ConsoleHelper.writeMessage("Invalid card values");
        }
    }
}
