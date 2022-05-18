package com.company.task.parser.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomArrayParserTest {
    CustomArrayParser parser;

    @BeforeMethod

    public void setUp() {
        parser = new CustomArrayParser();
    }

    @Test
    public void testParseToInteger() {
        List<String> list = new ArrayList<>();
        list.add("2131");
        list.add("3155");
        list.add("346");
        list.add("309");
        list.add("6317");
        list.add("573");
        list.add("814");
        list.add("911");
        int[] expected = {2131, 3155, 346, 309, 6317, 573, 814, 911};
        int[] actual = parser.parseToInteger(list);
        assertEquals(actual, expected);
    }
}