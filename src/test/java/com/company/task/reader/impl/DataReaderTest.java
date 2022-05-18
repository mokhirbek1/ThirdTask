package com.company.task.reader.impl;

import com.company.task.exception.TaskException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReaderTest {
    private static final Logger logger = Logger.getLogger(DataReader.class.toString());
    private static final String path = "C:\\Users\\Moxirbek\\IdeaProjects\\CustomArray\\src\\main\\resource\\number.txt";
    DataReader reader;

    @BeforeMethod
    public void setUp() {
        reader = new DataReader();
    }

    @Test
    public void testReadData() {
        List<String> expected = new ArrayList<>();
        List<String> actual;
        expected.add("1241");
        expected.add("342");
        expected.add("32423");
        expected.add("342");
        try{
            actual = reader.readData(path);
        }
        catch (TaskException e){
            logger.log(Level.WARNING, "Failed in the reading a data", e);
        }
    }
}