package com.hkadekar.anu.accountprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTranslatorTest {

    char[][] codedNumber0 = {
            {' ', '_', ' '},
            {'|', ' ', '|'},
            {'|', '_', '|'},
            {' ', ' ', ' '}
    };

    char[][] codedNumber1 = {
            {' ', ' ', ' '},
            {' ', ' ', '|'},
            {' ', ' ', '|'},
            {' ', ' ', ' '}
    };

    char[][] codedNumber2 = {
            {' ', '_', ' '},
            {' ', '_', '|'},
            {'|', '_', ' '},
            {' ', ' ', ' '}
    };

    char[][] codedNumber3 = {
            {' ', '_', ' '},
            {' ', '_', '|'},
            {' ', '_', '|'},
            {' ', ' ', ' '}
    };

    char[][] codedNumber4 = {
            {' ', ' ', ' '},
            {'|', '_', '|'},
            {' ', ' ', '|'},
            {' ', ' ', ' '}
    };

    char[][] codedNumber5 = {
            {' ', '_', ' '},
            {'|', '_', ' '},
            {' ', '_', '|'},
            {' ', ' ', ' '}
    };

    char[][] codedNumber6 = {
            {' ', '_', ' '},
            {'|', '_', ' '},
            {'|', '_', '|'},
            {' ', ' ', ' '}
    };

    char[][] codedNumber7 = {
            {' ', '_', ' '},
            {' ', ' ', '|'},
            {' ', ' ', '|'},
            {' ', ' ', ' '}
    };

    char[][] codedNumber8 = {
            {' ', '_', ' '},
            {'|', '_', '|'},
            {'|', '_', '|'},
            {' ', ' ', ' '}
    };

    char[][] codedNumber9 = {
            {' ', '_', ' '},
            {'|', '_', '|'},
            {' ', '_', '|'},
            {' ', ' ', ' '}
    };

    @Test
    void testCodedAccountNumberConvertor() throws InvalidCharacterException{
        char[][] codedAccountNumber = {
                {' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', ' ', '|', '_', ' ', ' ', ' ', '|', '|', '_', '|', '|', '_', '|'},
                {' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|', '|', '_', '|', ' ', ' ', '|', '|', '_', '|', ' ', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        long expectedAccountNumber = 123456789;

        long returnedAccountNumber = AccountTranslator.decipherAccountNumber(codedAccountNumber);

        Assertions.assertEquals(expectedAccountNumber, returnedAccountNumber);

    }

    @Test
    void testCodedAccountNumberConvertorWithString() {
        char[][] codedAccountNumber = {
                {' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', ' ', '|', '_', ' ', ' ', ' ', '|', '|', '_', '|', '|', '_', '|'},
                {' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|', '|', '_', '|', ' ', ' ', '|', '|', '_', '|', ' ', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        String expectedAccountNumber = "123456789";

        String returnedAccountNumber = AccountTranslator.decipherAccountNumberAsString(codedAccountNumber);

        Assertions.assertEquals(expectedAccountNumber, returnedAccountNumber);

    }

    @Test
    void testCodedAccountNumberConvertorWithStringWithError() {
        char[][] codedAccountNumber = {
                {' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', '|', '|', '_', ' ', ' ', ' ', '|', '|', '_', '|', '|', '_', '|'},
                {' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', '|', ' ', '|', '|', '_', '|', ' ', ' ', '|', '|', '_', '|', ' ', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        String expectedAccountNumber = "1234?6789";

        String returnedAccountNumber = AccountTranslator.decipherAccountNumberAsString(codedAccountNumber);

        Assertions.assertEquals(expectedAccountNumber, returnedAccountNumber);

    }

    @Test
    void testCodedNumberConvertor() throws InvalidCharacterException{

        long expectedNumber = 1;
        long returnedNumber = AccountTranslator.decipherNumber(codedNumber1);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = 0;
        returnedNumber = AccountTranslator.decipherNumber(codedNumber0);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = 2;
        returnedNumber = AccountTranslator.decipherNumber(codedNumber2);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = 3;
        returnedNumber = AccountTranslator.decipherNumber(codedNumber3);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = 4;
        returnedNumber = AccountTranslator.decipherNumber(codedNumber4);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = 5;
        returnedNumber = AccountTranslator.decipherNumber(codedNumber5);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = 6;
        returnedNumber = AccountTranslator.decipherNumber(codedNumber6);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = 7;
        returnedNumber = AccountTranslator.decipherNumber(codedNumber7);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = 8;
        returnedNumber = AccountTranslator.decipherNumber(codedNumber8);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = 9;
        returnedNumber = AccountTranslator.decipherNumber(codedNumber9);
        Assertions.assertEquals(expectedNumber, returnedNumber);
    }


    @Test
    void testInvalidCharEncoding(){

        char[][] invalidCodedNumber = {
                {' ', '_', ' '},
                {'|', '_', '|'},
                {'|', ' ', '|'},
                {' ', ' ', ' '}
        };

        Assertions.assertThrows(InvalidCharacterException.class, () -> {
            AccountTranslator.decipherNumber(invalidCodedNumber);
        });
    }

    @Test
    public void testInvalidAccountNumberCharacter() {
        char[][] invalidCodedNumber = {
                {' ', '_', ' '},
                {'|', '_', '|'},
                {'|', ' ', '|'},
                {' ', ' ', ' '}
        };

        String translatedValue = AccountTranslator.decipherNumberWithDefaultValue(invalidCodedNumber);
        Assertions.assertEquals("?", translatedValue);

    }

    @Test
    public void testValidAccountNumberAsString() {

        char[][] invalidCodedNumber = {
                {' ', '_', ' '},
                {'|', '_', '|'},
                {'|', ' ', '|'},
                {' ', ' ', ' '}
        };

        String expectedNumber = "1";
        String returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber1);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "0";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber0);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "2";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber2);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "3";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber3);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "4";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber4);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "5";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber5);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "6";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber6);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "7";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber7);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "8";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber8);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "9";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(codedNumber9);
        Assertions.assertEquals(expectedNumber, returnedNumber);

        expectedNumber = "?";
        returnedNumber = AccountTranslator.decipherNumberWithDefaultValue(invalidCodedNumber);
        Assertions.assertEquals(expectedNumber, returnedNumber);

    }
}
