package com.company.task.observer.impl;

import com.company.task.entity.CustomArray;
import com.company.task.entity.CustomArrayValues;
import com.company.task.observer.Observer;
import com.company.task.service.FindElementFromArray.FindElement;
import com.company.task.warehouse.Warehouse;

public class CustomArrayObserver implements Observer {
    private FindElement find;
    private CustomArrayValues values;
    private int id;
    private int sum;
    private int average;
    private int min;
    private int max;
    @Override
    public void actionPerformed(CustomArray customArray) {
        find = new FindElement(customArray);
        id = customArray.getId();
        sum = find.findSumOfElement();
        average = find.findAverageOfElement();
        min = find.findMin();
        max = find.findMax();
        values = new CustomArrayValues(id, sum, average, min, max);
        Warehouse.getInstance().add(id, values);
    }
}
