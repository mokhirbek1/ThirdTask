package com.company.task.reader;

import com.company.task.exception.TaskException;

import java.util.List;

public interface ArrayReader {
    public List<String> readData(String path) throws TaskException;
}
