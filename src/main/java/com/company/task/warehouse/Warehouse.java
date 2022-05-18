package com.company.task.warehouse;

import com.company.task.entity.CustomArray;
import com.company.task.entity.CustomArrayValues;
import com.company.task.observer.Observer;
import com.company.task.service.FindElementFromArray.FindElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private static Map<Integer, CustomArrayValues> listOfArrayValue = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public void add(Integer key, CustomArrayValues customArrayValues) {
        listOfArrayValue.put(key, customArrayValues);
    }

    public void remove(Integer key) {
        listOfArrayValue.remove(key);
    }

    public void addAll(Map<Integer, CustomArrayValues> listOfMap) {
        listOfArrayValue.putAll(listOfMap);
    }

    public CustomArrayValues getValue(Integer key) {
        return listOfArrayValue.get(key);
    }

}
