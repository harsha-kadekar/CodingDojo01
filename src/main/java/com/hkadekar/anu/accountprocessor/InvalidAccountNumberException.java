package com.hkadekar.anu.accountprocessor;

public class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException(String errorMessage){
        super(errorMessage);
    }
}
