package com.company.task.validator;

import java.util.regex.Pattern;

public class CustomArrayValidator {
    private static final String REGEX = "^[0-9]+$";
    public boolean checkForNumber(String number){
        return Pattern.matches(REGEX, number);
    }
}
