package com.company.task.parser.impl;

import com.company.task.parser.ArrayParser;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomArrayParser implements ArrayParser {
    private static final Logger logger = Logger.getLogger(CustomArrayParser.class.toString());
    public int[] parseToInteger(List<String> listOfString) {
        int length = listOfString.size();
        int[] arrayOfInteger = new int[length];
        for (int i = 0; i < length; i++) {
            arrayOfInteger[i] = Integer.parseInt(listOfString.get(i));
        }
        logger.log(Level.INFO, "Parsing finished");
        return arrayOfInteger;
    }
}
