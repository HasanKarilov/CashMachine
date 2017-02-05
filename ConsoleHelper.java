package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by hanaria on 2/2/17.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException{
        String line = "";
        try{
            line = reader.readLine();
            if(line.equalsIgnoreCase(res.getString("operation.EXIT"))){
                throw new InterruptOperationException();
            }
        }
        catch (IOException ignored)
        {
        }
        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = "";
        while(true){
            currencyCode = readString();
            if(currencyCode.length() == 3){
                break;
            }
            else writeMessage(res.getString("invalid.data"));
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String str = "";
        String[] nominalAndQuantity;
        int nominal = 0,quantity = 0;
        while (true){
            str = readString();
            nominalAndQuantity = str.split(" ");
            try
            {
                nominal = Integer.parseInt(nominalAndQuantity[0]);
                quantity = Integer.parseInt(nominalAndQuantity[1]);
            }
            catch (Exception e){
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if(nominal <= 0 || quantity <= 0 || nominalAndQuantity.length>2){
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return nominalAndQuantity;
    }

    public static Operation askOperation() throws InterruptOperationException{
        Integer ordinal;
        Operation operation;

        while (true)
        {
            writeMessage("Choose operation 1 INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            try{
                ordinal = Integer.parseInt(readString());
                operation = Operation.getAllowableOperationByOrdinal(ordinal);
                break;
            }
            catch (IllegalArgumentException  e){
            }
        }
        return operation;
    }
}