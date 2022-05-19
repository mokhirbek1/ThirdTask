package com.company.task.specification.impl;

import com.company.task.entity.CustomArray;
import com.company.task.service.findElementFromArray.FindElement;
import com.company.task.specification.Specification;

public class FindByAvrgSpecification implements Specification {
    private int average;
    public FindByAvrgSpecification(int average){
        this.average = average;
    }
    public boolean recognize(CustomArray customArray){
        FindElement find = new FindElement(customArray);
        boolean result = false;
        if (average==find.findAverageOfElement()){
            result = true;
        }
        return result;
    }
}
