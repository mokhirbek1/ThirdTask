package com.company.task.validator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomArrayValidatorTest {
    CustomArrayValidator validator;
    @BeforeMethod
    public void setUp() {
        validator = new CustomArrayValidator();
    }

    @Test
    public void testCheckForNumber() {
        String number = "1231";
        boolean expected = true;
        boolean actual = validator.checkForNumber(number);
        assertEquals(actual, expected);
    }
}