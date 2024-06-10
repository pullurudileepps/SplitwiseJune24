package com.example.SplitwiseJune24.commands;

import com.example.SplitwiseJune24.Exceptions.InvalidCommandException;

public interface Command {
    void execute(String input) throws InvalidCommandException;
}
