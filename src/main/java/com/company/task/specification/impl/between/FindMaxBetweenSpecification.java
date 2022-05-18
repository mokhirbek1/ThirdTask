package com.company.task.specification.impl.between;

import com.company.task.entity.CustomArray;
import com.company.task.service.FindElementFromArray.FindElement;
import com.company.task.specification.Specification;

public class FindMaxBetweenSpecification implements Specification {
    private int from;
    private int to;

    public FindMaxBetweenSpecification(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public boolean recognize(CustomArray customArray) {
        FindElement find = new FindElement(customArray);
        boolean result = false;
        if (from < find.findMax() && to > find.findMax()) {
            result = true;
        }
        return result;
    }

}
