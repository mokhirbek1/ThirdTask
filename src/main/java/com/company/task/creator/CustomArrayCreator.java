package com.company.task.creator;

import com.company.task.entity.CustomArray;
import com.company.task.exception.TaskException;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomArrayCreator {
    private static final Logger logger = Logger.getLogger(String.valueOf(CustomArrayCreator.class));

    public void arrayRandomCreate(CustomArray customArray, int from, int to) {
        try {
            int random;
            for (int i = 1; i < customArray.getSize(); i++) {
                random = new Random().nextInt(from, to);
                for (int j = 0; j < i; j++) {
                    if (customArray.getElement(j) != random) {
                        if (j == i - 1) {
                            customArray.setElement(random, i);
                        }
                    } else {
                        random = new Random().nextInt(from, to);
                        j = 0;
                    }
                }
            }
            logger.log(Level.INFO, "array created successfully");
        } catch (TaskException taskException) {
            logger.log(Level.WARNING, "failed in creating array", taskException);
        }
    }
}
