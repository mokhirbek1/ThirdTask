package com.company.task.service.BinarySearchImp;

import com.company.task.entity.CustomArray;
import com.company.task.service.Search;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearchFromArray implements Search {
    public static final Logger logger = Logger.getLogger(String.valueOf(BinarySearchFromArray.class));

    public int searchElement(CustomArray sortedArray, int key) {
        int index=-1;
        if (sortedArray.isSorted()) {
            index = Arrays.binarySearch(sortedArray.getArray(), key);
            if (index < 0) {
                logger.log(Level.WARNING, "Value is didn't found!");
            }
        } else {
            logger.log(Level.WARNING, "Array didn't sorted");
        }
        return index;
    }
}
