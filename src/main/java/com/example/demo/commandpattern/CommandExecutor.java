package com.example.demo.commandpattern;

import com.example.demo.commandpattern.utils.Command;
import com.example.demo.commandpattern.utils.Database;


abstract public class CommandExecutor {
    private Database database;

    public CommandExecutor(Database database){
        this.database = database;
    }

    public void execute(Command command) throws Exception {
        if(isValid(command))
            throw new Exception("Not a valid command");
        executeValidCommand(command);
    }

    protected abstract boolean isApplicable(Command command);

    protected abstract boolean isValid(Command command);

    protected abstract void executeValidCommand(Command command);
}
