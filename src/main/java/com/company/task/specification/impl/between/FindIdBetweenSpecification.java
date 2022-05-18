package com.company.task.specification.impl.between;

import com.company.task.entity.CustomArray;
import com.company.task.specification.Specification;

public class FindIdBetweenSpecification implements Specification {
    private int from;
    private int to;

    public FindIdBetweenSpecification(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public boolean recognize(CustomArray customArray) {
        boolean result = false;
        if (from<customArray.getId()&& to>customArray.getId()) {
            result = true;
        }

        return result;
    }
}
