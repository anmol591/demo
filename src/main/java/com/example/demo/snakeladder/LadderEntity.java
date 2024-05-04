package com.example.demo.snakeladder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LadderEntity {
    private String ladderId;
    private int start;
    private int end;
}
