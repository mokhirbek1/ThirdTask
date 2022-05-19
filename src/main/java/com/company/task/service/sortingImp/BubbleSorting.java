package com.company.task.service.sortingImp;

import com.company.task.entity.CustomArray;
import com.company.task.exception.TaskException;
import com.company.task.service.Sort;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSorting implements Sort {
    private static final Logger logger = Logger.getLogger(String.valueOf(BubbleSorting.class));

    public void sortArray(CustomArray customArray) {
        try {
            int length = customArray.getSize();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - 1 - i; j++) {
                    if (customArray.getElement(j) > customArray.getElement(j + 1)) {
                        int memory = customArray.getElement(j);
                        customArray.setElement(customArray.getElement(j + 1), j);
                        customArray.setElement(memory, j + 1);
                    }
                }
            }
            customArray.setSorted(true);
        } catch (TaskException e) {
            logger.log(Level.WARNING, "failed in bubble sorting the array", e.getMessage());
        }
    }
}
