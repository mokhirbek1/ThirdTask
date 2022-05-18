package com.company.task.reader.impl;

import com.company.task.exception.TaskException;
import com.company.task.reader.ArrayReader;
import com.company.task.validator.CustomArrayValidator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class DataReader implements ArrayReader {
    private static final Logger logger = Logger.getLogger(DataReader.class.toString());
    private static final String REGEX = "\\s";

    public List<String> readData(String path) throws TaskException {
        List<String> list = new ArrayList<>();
        CustomArrayValidator validator = new CustomArrayValidator();
        File file = new File(path);
        if (path==null){
            throw new TaskException("Path is incorrect");
        }
        if (!file.exists()){
            throw new TaskException("File doesn't exist!");
        }
        try{
            Stream<String> stream = Files.lines(Paths.get(path));
            list = stream.flatMap(element-> Stream.of(element.split(REGEX)))
                    .filter(validator::checkForNumber)
                    .toList();
            logger.log(Level.INFO, "Validating is finished");
        }catch (IOException e){
            logger.log(Level.WARNING, "Didn't found the lines");
        }
        return list;
    }
}
