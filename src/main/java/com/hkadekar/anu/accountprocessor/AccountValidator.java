package com.hkadekar.anu.accountprocessor;

import java.util.*;

public class AccountValidator {
    private static Map<String, List<String>> possibleReplacements;

    static {
        possibleReplacements = new HashMap<>();
        possibleReplacements.put("1", Arrays.asList("7"));
        possibleReplacements.put("3", Arrays.asList("9"));
        possibleReplacements.put("5", Arrays.asList("6", "9"));
        possibleReplacements.put("6", Arrays.asList("8, 5"));
        possibleReplacements.put("7", Arrays.asList("1"));
        possibleReplacements.put("8", Arrays.asList("0", "9", "5"));
        possibleReplacements.put("9", Arrays.asList("8", "3", "5"));
        possibleReplacements.put("0", Arrays.asList("8"));
    }

    

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
