package com.javarush.test.level26.lesson15.big01;

/**
 * Created by hanaria on 2/2/17.
 */
public enum Operation
{
    INFO, DEPOSIT, WITHDRAW, EXIT;
    public static Operation getAllowableOperationByOrdinal(Integer i){
        switch (i){
            case 1: return INFO;
            case 2: return DEPOSIT;
            case 3: return WITHDRAW;
            case 4: return EXIT;
            default: throw new IllegalArgumentException();
        }
    }
}