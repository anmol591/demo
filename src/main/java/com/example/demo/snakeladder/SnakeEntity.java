package com.example.demo.snakeladder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SnakeEntity {
    private String snakeId;
    private int head;
    private int tail;
}
