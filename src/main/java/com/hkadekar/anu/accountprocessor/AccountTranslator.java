package com.hkadekar.anu.accountprocessor;

import java.util.Arrays;

public class AccountTranslator {
    public static long decipherAccountNumber(char[][] codedAccountNumber) throws InvalidCharacterException{
        long accountNumber = 0;

        char[][] singleNumber = new char[4][];
        for(int i = 0; i < 27; i += 3){
            singleNumber[0] = Arrays.copyOfRange(codedAccountNumber[0], i, i + 3 );
            singleNumber[1] = Arrays.copyOfRange(codedAccountNumber[1], i, i + 3 );
            singleNumber[2] = Arrays.copyOfRange(codedAccountNumber[2], i, i + 3 );
            singleNumber[3] = Arrays.copyOfRange(codedAccountNumber[3], i, i + 3 );

            long value = decipherNumber(singleNumber);
            accountNumber = accountNumber*10 + value;
        }

        return accountNumber;
    }

    public static String decipherNumberWithDefaultValue(char[][] codedNumber) {
        String number = "?";
        try {
            number = String.valueOf(decipherNumber(codedNumber));
        } catch (InvalidCharacterException exp){
            number = "?";
        }
        return number;
    }

    public static long decipherNumber(char[][] codedNumber) throws InvalidCharacterException{

        String row1 = String.valueOf(codedNumber[0]);
        String row2 = String.valueOf(codedNumber[1]);
        String row3 = String.valueOf(codedNumber[2]);
        String row4 = String.valueOf(codedNumber[3]);

        if(row1.equals(" _ ") && row2.equals("| |") && row3.equals("|_|") && row4.equals("   ")){
            return 0;
        } else if(row1.equals("   ") && row2.equals("  |") && row3.equals("  |") && row4.equals("   ")){
            return 1;
        } else if(row1.equals(" _ ") && row2.equals(" _|") && row3.equals("|_ ") && row4.equals("   ")){
            return 2;
        } else if(row1.equals(" _ ") && row2.equals(" _|") && row3.equals(" _|") && row4.equals("   ")){
            return 3;
        } else if(row1.equals("   ") && row2.equals("|_|") && row3.equals("  |") && row4.equals("   ")){
            return 4;
        } else if(row1.equals(" _ ") && row2.equals("|_ ") && row3.equals(" _|") && row4.equals("   ")){
            return 5;
        } else if(row1.equals(" _ ") && row2.equals("|_ ") && row3.equals("|_|") && row4.equals("   ")){
            return 6;
        } else if(row1.equals(" _ ") && row2.equals("  |") && row3.equals("  |") && row4.equals("   ")){
            return 7;
        } else if(row1.equals(" _ ") && row2.equals("|_|") && row3.equals("|_|") && row4.equals("   ")){
            return 8;
        } else if(row1.equals(" _ ") && row2.equals("|_|") && row3.equals(" _|") && row4.equals("   ")){
            return 9;
        } else {
            throw new InvalidCharacterException(String.format("Invalid character found: row1 %s, row2 %s, row3 %s", row1, row2, row3));
        }

    }


}
