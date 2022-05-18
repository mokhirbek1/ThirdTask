package com.company.task.service.SortingImp;

import com.company.task.entity.CustomArray;
import com.company.task.exception.TaskException;
import com.company.task.service.Sort;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectionSorting implements Sort {
    private static final Logger logger = Logger.getLogger(String.valueOf(SelectionSorting.class));
    public void sortArray(CustomArray customArray) {
        try{
            int length = customArray.getSize();
            for (int i = 0; i < length; i++) {
                int min = customArray.getElement(i);
                int id = i;
                for (int j = i+1; j < length; j++) {
                    if (customArray.getElement(j) < min) {
                        min = customArray.getElement(j);
                        id = j;
                    }
                }
                int memory = customArray.getElement(i);
                customArray.setElement(min, i);
                customArray.setElement(memory, id);
            }
            customArray.setSorted(true);
        }
        catch (TaskException e){
            logger.log(Level.INFO, "failed in selection sorting the array", e.getMessage());
        }
    }
}
