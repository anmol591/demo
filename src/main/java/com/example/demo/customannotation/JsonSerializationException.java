package com.example.demo.customannotation;

public class JsonSerializationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    JsonSerializationException(String msg){
        super(msg);
    }
}
