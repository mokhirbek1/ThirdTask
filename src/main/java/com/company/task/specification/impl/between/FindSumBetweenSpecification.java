package com.company.task.specification.impl.between;

import com.company.task.entity.CustomArray;
import com.company.task.service.findElementFromArray.FindElement;
import com.company.task.specification.Specification;

public class FindSumBetweenSpecification implements Specification {
    private int from;
    private int to;

    public FindSumBetweenSpecification(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public boolean recognize(CustomArray customArray) {
        FindElement find = new FindElement(customArray);
        boolean result = false;
        if (from < find.findSumOfElement() && to > find.findSumOfElement()) {
            result = true;
        }
        return result;
    }
}
