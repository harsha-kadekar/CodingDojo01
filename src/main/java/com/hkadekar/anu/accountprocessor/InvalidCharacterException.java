package com.hkadekar.anu.accountprocessor;

public class InvalidCharacterException extends Exception {
    public InvalidCharacterException(String errorMessage){
        super(errorMessage);
    }
}
