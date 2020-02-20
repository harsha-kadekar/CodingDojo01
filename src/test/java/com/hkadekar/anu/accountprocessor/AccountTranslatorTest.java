package com.hkadekar.anu.accountprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTranslatorTest {

    @Test
    void testCodedAccountNumberConvertor(){
        char[][] codedAccountNumber = {
                {' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', ' ', '|', '_', ' ', '|', '_', ' ', ' ', ' ', '|', '|', '_', '|', '|', '_', '|'},
                {' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|', '|', '_', '|', ' ', ' ', '|', '|', '_', '|', ' ', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        long expectedAccountNumber = 123456789;

        long returnedAccountNumber = AccountTranslator.decipherAccountNumber(codedAccountNumber);

        Assertions.assertEquals(expectedAccountNumber, returnedAccountNumber);

    }
}
