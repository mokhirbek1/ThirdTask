package com.company.task.specification.impl;

import com.company.task.entity.CustomArray;
import com.company.task.service.findElementFromArray.FindElement;
import com.company.task.specification.Specification;

public class FindBySumSpecification implements Specification {
    private int sum;

    public FindBySumSpecification(int sum) {
        this.sum = sum;
    }

    public boolean recognize(CustomArray customArray) {
        FindElement find = new FindElement(customArray);
        boolean result = false;

        if (sum == find.findSumOfElement()) {
            result = true;
        }
        return result;
    }
}
