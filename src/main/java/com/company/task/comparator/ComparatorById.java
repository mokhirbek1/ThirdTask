package com.company.task.comparator;

import com.company.task.entity.CustomArray;

import java.util.Comparator;

public class ComparatorById implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray customArray1, CustomArray customArray2) {
        return customArray1.getId() - customArray2.getId();
    }
}
