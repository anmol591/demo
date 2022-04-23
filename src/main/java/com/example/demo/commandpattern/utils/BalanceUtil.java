package com.example.demo.commandpattern.utils;

public class BalanceUtil {
    public void balanceProvider(String user,String type){
        if(type == "fetch")
            fetchBalance();
        else
            updateBalance();

    }

    private int fetchBalance(){
        return 5;
    }

    private void updateBalance(){
        System.out.println("Balance updated successfully");
    }
}
