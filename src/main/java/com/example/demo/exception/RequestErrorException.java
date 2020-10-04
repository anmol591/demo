package com.example.demo.exception;

public class RequestErrorException extends RuntimeException {

    public RequestErrorException(String msg){
        super(msg);
    }
}
