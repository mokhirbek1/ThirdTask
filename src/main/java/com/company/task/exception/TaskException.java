package com.company.task.exception;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TaskException extends Exception {
    public TaskException(String message, Throwable throwable){
        super(message, throwable);
    }
    public TaskException(String message){
        super(message);
    }
}
