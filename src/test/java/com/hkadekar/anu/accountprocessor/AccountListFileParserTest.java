package com.hkadekar.anu.accountprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AccountListFileParserTest {

    @Test
    public void testAccountListsFileReader() throws InvalidCharacterException, IOException, InvalidFileException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("validAccountList").getPath();
        long[] actualAccountNumbers = AccountListFileParser.getAccountListFromFile(accountListFile);
        long[] expectedAccountNumbers = {123456789L, 987654321L, 543210987L, 123467890L};

        Assertions.assertArrayEquals(expectedAccountNumbers, actualAccountNumbers);

    }

    @Test
    public void testEmptyAccountListsFileReader() throws InvalidFileException, IOException, InvalidFileException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("errorAccountList1").getPath();

        Assertions.assertThrows(InvalidFileException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });


    }

    @Test
    public void testIncompleteAccountListsFileReader() throws InvalidFileException, IOException, InvalidFileException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("errorAccountList2").getPath();

        Assertions.assertThrows(InvalidFileException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });
    }

    @Test
    public void testMissingDataAccountListFilereader() throws InvalidFileException, IOException, InvalidFileException {
        String accountListFile = AccountListFileParser.class.getClassLoader().getResource("errorAccountList3").getPath();

        Assertions.assertThrows(InvalidFileException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });
    }

    @Test
    public void testInvalidFileExtraCharacterAccountListFileReader() throws InvalidFileException, InvalidCharacterException, IOException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("errorAccountList4").getPath();

        Assertions.assertThrows(InvalidFileException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });
    }

    @Test
    public void testInvalidCharacterAccountListFileReader() throws InvalidCharacterException, InvalidFileException, IOException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("errorAccountList5").getPath();

        Assertions.assertThrows(InvalidCharacterException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });
    }
}
