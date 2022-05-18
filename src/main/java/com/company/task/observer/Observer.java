package com.company.task.observer;

import com.company.task.entity.CustomArray;
import com.company.task.entity.CustomArrayValues;

public interface Observer {
    void actionPerformed(CustomArray customArray);
}
