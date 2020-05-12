package com.hkadekar.anu.accountprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

import java.io.IOException;
import java.util.List;

public class AccountListFileParserTest {

    @Test
    public void testAccountListsFileReader() throws InvalidCharacterException, IOException, InvalidFileException, InvalidAccountNumberException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("accountlistfiles/validAccountList").getPath();
        long[] actualAccountNumbers = AccountListFileParser.getAccountListFromFile(accountListFile);
        long[] expectedAccountNumbers = {123456789L, 345882865L, 543210987L, 123456789L};

        Assertions.assertArrayEquals(expectedAccountNumbers, actualAccountNumbers);

    }

    @Test
    public void testAccountListsFileReaderWithErrorCode() throws IOException, InvalidFileException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("accountlistfiles/validAccountList").getPath();
        List<AccountNumber> actualAccountNumbers = AccountListFileParser.getAccountListFromFileWithErrorCode(accountListFile);

        AccountNumber ac1 = new AccountNumber("123456789", "");
        AccountNumber ac2 = new AccountNumber("345882865", "");
        AccountNumber ac3 = new AccountNumber("543210987", "");
        AccountNumber ac4 = new AccountNumber("123456789", "");

        assertThat(actualAccountNumbers, hasItems(ac1, ac2, ac3, ac4));

    }

    @Test
    public void testAccountListsFileReaderWithMixedErrorCode() throws IOException, InvalidFileException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("accountlistfiles/mixedAccountList").getPath();
        List<AccountNumber> actualAccountNumbers = AccountListFileParser.getAccountListFromFileWithErrorCode(accountListFile);

        AccountNumber ac1 = new AccountNumber("123456789", "");
        AccountNumber ac2 = new AccountNumber("345882?65", "ILL");
        AccountNumber ac3 = new AccountNumber("543210987", "");
        AccountNumber ac4 = new AccountNumber("123467890", "ERR");

        assertThat(actualAccountNumbers, hasItems(ac1, ac2, ac3, ac4));

    }

    @Test
    public void testEmptyAccountListsFileReader() throws InvalidFileException, IOException, InvalidFileException, InvalidAccountNumberException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("accountlistfiles/errorAccountList1").getPath();

        Assertions.assertThrows(InvalidFileException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });


    }

    @Test
    public void testIncompleteAccountListsFileReader() throws InvalidFileException, IOException, InvalidFileException, InvalidAccountNumberException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("accountlistfiles/errorAccountList2").getPath();

        Assertions.assertThrows(InvalidFileException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });
    }

    @Test
    public void testMissingDataAccountListFilereader() throws InvalidFileException, IOException, InvalidFileException, InvalidAccountNumberException {
        String accountListFile = AccountListFileParser.class.getClassLoader().getResource("accountlistfiles/errorAccountList3").getPath();

        Assertions.assertThrows(InvalidFileException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });
    }

    @Test
    public void testInvalidFileExtraCharacterAccountListFileReader() throws InvalidFileException, InvalidCharacterException, IOException, InvalidAccountNumberException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("accountlistfiles/errorAccountList4").getPath();

        Assertions.assertThrows(InvalidFileException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });
    }

    @Test
    public void testInvalidCharacterAccountListFileReader() throws InvalidCharacterException, InvalidFileException, IOException, InvalidAccountNumberException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("accountlistfiles/errorAccountList5").getPath();

        Assertions.assertThrows(InvalidCharacterException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });
    }

    @Test
    public void testInvalidAccountNumberFileReader() throws InvalidCharacterException, InvalidFileException, IOException, InvalidAccountNumberException {
        String accountListFile = AccountListFileParserTest.class.getClassLoader().getResource("accountlistfiles/errorAccountList6").getPath();

        Assertions.assertThrows(InvalidAccountNumberException.class, () -> {
            AccountListFileParser.getAccountListFromFile(accountListFile);
        });
    }
}
