package com.hkadekar.anu.accountprocessor;

public class AccountValidator {
    public static boolean isAccountValid(long accountNumber){
        long sum = 0;
        int digit = 1;
        long x = accountNumber;
        while(x > 0){
            long y = x%10;
            sum += (digit*y);
            x /= 10;
            digit++;
        }
        return sum % 11 == 0;
    }
}
