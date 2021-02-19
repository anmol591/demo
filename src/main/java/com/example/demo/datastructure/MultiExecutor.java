package com.example.demo.datastructure;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {
    List<Runnable> tasks;
    public MultiExecutor(List<Runnable>tasks){
        this.tasks = tasks;
    }
    public void executeAll(){

        for(Runnable task : tasks){
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
