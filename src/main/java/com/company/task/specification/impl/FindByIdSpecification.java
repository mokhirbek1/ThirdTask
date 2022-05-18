package com.company.task.specification.impl;

import com.company.task.entity.CustomArray;
import com.company.task.specification.Specification;

import java.util.logging.Logger;

public class FindByIdSpecification implements Specification {
    private int id;

    public FindByIdSpecification(int id) {
        this.id = id;
    }

    public boolean recognize(CustomArray customArray) {
        boolean result = false;
        if (customArray.getId() == id) {
            result = true;
        }

        return result;
    }
}
