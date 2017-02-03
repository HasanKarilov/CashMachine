package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by hanaria on 2/2/17.
 */
interface Command {
    void execute() throws InterruptOperationException;
}