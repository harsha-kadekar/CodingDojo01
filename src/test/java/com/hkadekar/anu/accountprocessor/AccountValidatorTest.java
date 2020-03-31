package com.hkadekar.anu.accountprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountValidatorTest {

    @Test
    void testValidAccountNumber()  {
        long validAccountNumber = 345882865l;
        boolean validAccount = AccountValidator.isAccountValid(validAccountNumber);
        Assertions.assertEquals(true, validAccount);
    }

    @Test
    void testInvalidAccountNumber() {
        //123456789L, 987654321L, 543210987L, 123467890L
        long invalidAccountNumber = 123467890l;
        boolean invalidAccount = AccountValidator.isAccountValid(invalidAccountNumber);
        Assertions.assertEquals(false, invalidAccount);
    }
}
