package com.hkadekar.anu.accountprocessor;

public class InvalidFileException extends Exception {
    public InvalidFileException(String errorMessage) {
        super(errorMessage);
    }
}
