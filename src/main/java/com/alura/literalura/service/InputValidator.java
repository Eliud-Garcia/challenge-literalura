package com.alura.literalura.service;

import java.util.Scanner;

public class InputValidator {

    public boolean isValidInteger(String s){
        if(s == null || s.trim().isBlank()) return false;
        try{
            int x = Integer.parseInt(s.trim());
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isValidInteger(String input, int min, int max) {
        if (!isValidInteger(input)) return false;
        int value = Integer.parseInt(input.trim());
        return value >= min && value <= max;
    }

    public int parseIntegerWithRetry(String message, Scanner en){
        int value = 0;
        while(true){
            String input = en.nextLine();
            if(isValidInteger(input)){
                value = Integer.parseInt(input.trim());
                break;
            }else{
                System.out.println(message);
            }
        }
        return value;
    }
}
