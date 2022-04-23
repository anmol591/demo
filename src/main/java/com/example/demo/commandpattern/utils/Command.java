package com.example.demo.commandpattern.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Command {
    private String commandName;
    private List<String> params;

}
