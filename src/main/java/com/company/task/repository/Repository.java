package com.company.task.repository;

import com.company.task.entity.CustomArray;
import com.company.task.service.Sort;
import com.company.task.specification.Specification;

import java.util.List;

public interface Repository {
    List<CustomArray> query(Specification specification);
    void add(CustomArray customArray);
    void delete(int id);
    void sort(Sort sort);
}
