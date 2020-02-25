package com.hkadekar.anu.accountprocessor;

import java.util.Arrays;

public class AccountTranslator {
    public static long decipherAccountNumber(char[][] codedAccountNumber){
        long accountNumber = 0;

        return accountNumber;
    }


    public static long decipherNumber(char[][] codedNumber){

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
        } else {
            return 9;
        }

    }


}
