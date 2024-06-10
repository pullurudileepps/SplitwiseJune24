package com.example.SplitwiseJune24.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    static Map<String, Command> map;

    private CommandRegistry() {
        map = new HashMap<>();
    }
    private static CommandRegistry INSTANCE = new CommandRegistry();

    public static CommandRegistry getInstance(){
        return INSTANCE;
    }
    public void addCommand(String name, Command command){
        map.put(name, command);
    }

    public Command getCommand(String input){
        for (Map.Entry<String, Command> entry : map.entrySet()) {
            String key = entry.getKey();
            if(input.contains(key)){
                return entry.getValue();
            }
        }
        throw new UnsupportedOperationException("Please re-look at the syntax");
    }
}
