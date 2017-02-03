package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by hanaria on 2/2/17.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
            ConsoleHelper.writeMessage("Do you really want to quit? <y,n>");
            String answer = ConsoleHelper.readString().trim();
            if (answer.equalsIgnoreCase("y"))
            {
                ConsoleHelper.writeMessage("Good bye!");
            }
     }
}