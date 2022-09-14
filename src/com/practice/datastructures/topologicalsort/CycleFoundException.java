package com.practice.datastructures.topologicalsort;

public class CycleFoundException extends RuntimeException{
    public CycleFoundException(String message){
        super(message);
    }
}
