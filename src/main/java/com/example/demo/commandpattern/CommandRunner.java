package com.example.demo.commandpattern;

import com.example.demo.commandpattern.utils.Command;
import com.example.demo.commandpattern.utils.Database;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CommandRunner {
    List<CommandExecutor> commandExecutors;

    public void executeCommand(Command command) throws Exception {
       for(CommandExecutor commandExecutor : commandExecutors){
           if(!commandExecutor.isApplicable(command))
               throw new Exception("Invalid params");
           commandExecutor.execute(command);
       }
    }

    public static void main(String args[]){
        try {
            List<String> params = new ArrayList<>();
            params.add("Utkarsh");
            params.add("fetch");
            Command command = new Command("Recharge",params);

            CommandExecutor executor = new BalanceCommandExecutor(new Database());
            List<CommandExecutor> executors = new ArrayList<>();
            executors.add(executor);

            CommandRunner runner = new CommandRunner(executors);
            runner.executeCommand(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
