package com.company.task.specification.impl.between;

import com.company.task.entity.CustomArray;
import com.company.task.service.findElementFromArray.FindElement;
import com.company.task.specification.Specification;

public class FindAvrgBetweenSpecification implements Specification {
    private int from;
    private int to;

    public FindAvrgBetweenSpecification(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public boolean recognize(CustomArray customArray) {
        FindElement find = new FindElement(customArray);
        boolean result = false;
        if (from < find.findAverageOfElement() && to > find.findAverageOfElement()) {
            result = true;
        }
        return result;
    }
}
