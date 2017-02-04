package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by hanaria on 2/5/17.
 */
public class LoginCommand implements Command
{
    private final String cardNumber = "123456789012";
    private final String pinCode = "1234";
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
            if(card.length()!=12 && pin.length() !=4)
            {
                ConsoleHelper.writeMessage("Invalid card values");
                continue;
            }
            if(card.equals(cardNumber) && pin.equals(pinCode))
            {
                ConsoleHelper.writeMessage("Verification success!");
                break;
            }
        }
    }
}
