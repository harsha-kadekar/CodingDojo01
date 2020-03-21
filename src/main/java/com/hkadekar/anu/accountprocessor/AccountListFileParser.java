package com.hkadekar.anu.accountprocessor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AccountListFileParser {

    private static void validateFileContents(List<String> lines) throws InvalidFileException{



        for(String line: lines){
            if(line.length() < 27){
                throw new InvalidFileException("Each line in the file should have 27 characters");
            }
            char[] lineCharacters = line.toCharArray();
            for(int j = 0; j < 27; j++){
                if(lineCharacters[j] != ' ' && lineCharacters[j] != '_' && lineCharacters[j] != '|'){
                    throw new InvalidFileException(String.format("Invalid characters found in the file; Allowed are ' ', '_', '|'; Found %c", lineCharacters[j]));
                }
            }
        }

    }


    public static long[] getAccountListFromFile(String accountListFile) throws InvalidFileException{
        long[] accountNumbers = null;

        List<String> fileLines = new ArrayList<>();

        try{
            fileLines = Files.readAllLines(Paths.get(accountListFile), StandardCharsets.UTF_8);

            if(fileLines.size() == 0){
                throw new InvalidFileException("File did not had any coded account numbers");
            }

            if(fileLines.size() % 4 != 0){
                throw new InvalidFileException("Incomplete file found; Number of lines in file should be multiple of 4");
            }

            for(int i = 0; i < fileLines.size(); i+=4){
                char[] line1 = fileLines.get(i).toCharArray();
                char[] line2 = fileLines.get(i+1).toCharArray();
                char[] line3 = fileLines.get(i+2).toCharArray();
                char[] line4 = fileLines.get(i+3).toCharArray();

                if(line1.length < 27 || line2.length < 27 || line3.length < 27 || line4.length < 27){
                    throw new InvalidFileException("Each line in the file should have 27 characters");
                }

                if(fileLines.get(i+3).trim().length() != 0){
                    throw new InvalidFileException("4th line of each encoded account number should be empty line");
                }

                for(int j = 0; j < 27; j++){
                    if(line1[j] != ' ' && line1[j] != '_' && line1[j] != '|'){
                        throw new InvalidFileException(String.format("Invalid characters found in the file; Allowed are ' ', '_', '|'; Found %c", line1[j]));
                    }

                    if(line2[j] != ' ' && line2[j] != '_' && line2[j] != '|'){
                        throw new InvalidFileException(String.format("Invalid characters found in the file; Allowed are ' ', '_', '|'; Found %c", line2[j]));
                    }

                    if(line3[j] != ' ' && line3[j] != '_' && line3[j] != '|'){
                        throw new InvalidFileException(String.format("Invalid characters found in the file; Allowed are ' ', '_', '|'; Found %c", line3[j]));
                    }
                }

                char[][] encodedAccountNumber = new char[4][];
                encodedAccountNumber[0] = line1;
                encodedAccountNumber[1] = line2;
                encodedAccountNumber[2] = line3;
                encodedAccountNumber[3] = line4;




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
