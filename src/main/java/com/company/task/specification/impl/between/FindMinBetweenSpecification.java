package com.company.task.specification.impl.between;

import com.company.task.entity.CustomArray;
import com.company.task.service.findElementFromArray.FindElement;
import com.company.task.specification.Specification;

public class FindMinBetweenSpecification implements Specification {
    private int from;
    private int to;

    public FindMinBetweenSpecification(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public boolean recognize(CustomArray customArray) {
        FindElement find = new FindElement(customArray);
        boolean result = false;
        if (from < find.findMin() && to > find.findMin()) {
            result = true;
        }
        return result;
    }
}
