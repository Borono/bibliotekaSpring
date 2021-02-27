package com.example.bibliotekaaa.model.exceptions;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(){
        super("Vnesete argumenti");
    }
}
