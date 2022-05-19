package com.company.task.service.sortingImp;

import com.company.task.entity.CustomArray;
import com.company.task.exception.TaskException;
import com.company.task.service.Sort;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertionSorting implements Sort {
    private static final Logger logger = Logger.getLogger(String.valueOf(InsertionSorting.class));
    public void sortArray(CustomArray customArray) {
        try{
            int length = customArray.getSize();
            for (int i = 1; i < length; i++) {
                int memory = customArray.getElement(i);
                int j = i - 1;
                while (j >= 0 && memory < customArray.getElement(j)) {
                    customArray.setElement(customArray.getElement(j), j+1);
                    j--;
                }
                customArray.setElement(memory, j+1);
            }
            customArray.setSorted(true);
        }
        catch (TaskException e){
            logger.log(Level.WARNING, "failed in insertion sorting the array", e.getMessage());
        }
    }
}
