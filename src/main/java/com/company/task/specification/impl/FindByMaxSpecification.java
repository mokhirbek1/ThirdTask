package com.company.task.specification.impl;

import com.company.task.entity.CustomArray;
import com.company.task.service.findElementFromArray.FindElement;
import com.company.task.specification.Specification;

public class FindByMaxSpecification implements Specification {
    private int max;

    public FindByMaxSpecification(int max) {
        this.max = max;
    }

    public boolean recognize(CustomArray customArray) {
        FindElement find = new FindElement(customArray);
        boolean result = false;
        if (max == find.findMax()) {
            result = true;
        }
        return result;
    }
}
