package com.company.task.observer.impl;

import com.company.task.entity.CustomArray;
import com.company.task.entity.CustomArrayValues;
import com.company.task.observer.Observer;
import com.company.task.service.findElementFromArray.FindElement;
import com.company.task.warehouse.Warehouse;

public class CustomArrayObserver implements Observer {
    @Override
    public void actionPerformed(CustomArray customArray) {
        FindElement find;
        CustomArrayValues values;
        int id;
        int sum;
        int average;
        int min;
        int max;
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
