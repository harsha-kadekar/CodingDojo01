package com.hkadekar.anu.accountprocessor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AccountListFileParser {
    public static long[] getAccountListFromFile(String accountListFile){
        long[] accountNumbers = null;

        List<String> fileLines = new ArrayList<>();

        try{
            fileLines = Files.readAllLines(Paths.get(accountListFile), StandardCharsets.UTF_8);

            for(int i = 0; i < fileLines.size(); i+=4){
                char[] line1 = fileLines.get(i).toCharArray();
                char[] line2 = fileLines.get(i+1).toCharArray();
                char[] line3 = fileLines.get(i+2).toCharArray();
                char[] line4 = fileLines.get(i+3).toCharArray();



            }

        }catch (IOException exp){
            System.out.println(exp);
            exp.printStackTrace();
        }

        return accountNumbers;
    }

    private static char[][] getCodedAccountNumberAt(List<String> fileLines, int index){
        char[][] codedAccountNumber = new char[4][];

        

        return codedAccountNumber;
    }
}
