package com.company.task.specification;

import com.company.task.entity.CustomArray;
import com.company.task.service.FindElementFromArray.FindElement;

public interface Specification {
    boolean recognize(CustomArray customArray);
}
