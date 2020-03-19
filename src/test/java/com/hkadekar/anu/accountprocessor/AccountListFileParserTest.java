package com.hkadekar.anu.accountprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AccountListFileParserTest {

    @Test
    public void testAccountListsFileReader(){
        String accountListFile = "";
        long[] actualAccountNumbers = AccountListFileParser.getAccountListFromFile(accountListFile);
        long[] expectedAccountNumbers = {123456789L, 987654321L, 543210987L, 123467890L};

        Assertions.assertArrayEquals(expectedAccountNumbers, actualAccountNumbers);

    }
}
