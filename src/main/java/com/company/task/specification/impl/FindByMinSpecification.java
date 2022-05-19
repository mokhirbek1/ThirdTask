package com.company.task.specification.impl;

import com.company.task.entity.CustomArray;
import com.company.task.service.findElementFromArray.FindElement;
import com.company.task.specification.Specification;

public class FindByMinSpecification implements Specification {
    private int min;

    public FindByMinSpecification(int min) {
        this.min = min;
    }

    public boolean recognize(CustomArray customArray) {
        FindElement find = new FindElement(customArray);
        boolean result = false;
        if (min == find.findMin()) {
            result = true;
        }
        return result;
    }
}
