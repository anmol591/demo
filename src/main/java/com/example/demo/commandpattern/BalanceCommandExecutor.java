package com.example.demo.commandpattern;

import com.example.demo.commandpattern.utils.Command;
import com.example.demo.commandpattern.utils.Database;


public class BalanceCommandExecutor extends CommandExecutor {

    private final String commandName = "BALANCE";

    public BalanceCommandExecutor(Database database) {
        super(database);
    }

    @Override
    protected boolean isApplicable(Command command) {
       return command.getCommandName().equalsIgnoreCase(commandName);
    }

    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() != 2;
    }

    @Override
    protected void executeValidCommand(Command command) {
      String user = command.getParams().get(0);
      String type = command.getParams().get(1);
        System.out.println("Command executed successfully");
    }
}
