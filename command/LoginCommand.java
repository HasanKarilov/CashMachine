package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

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
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    private String card, pin;

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            try
            {
                ConsoleHelper.writeMessage(res.getString("specify.data"));
                card = ConsoleHelper.readString();
                pin = ConsoleHelper.readString();
            }
            catch (IllegalArgumentException e){

            }
            if(validCreditCards.containsKey(card))
            {
                if(validCreditCards.getString(card).equals(pin))
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), card));
                    break;
                }
                else
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), card));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            }
            else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), card));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

        }
    }
}
