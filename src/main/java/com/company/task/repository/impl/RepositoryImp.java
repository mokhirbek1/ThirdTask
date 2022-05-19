package com.company.task.repository.impl;

import com.company.task.entity.CustomArray;
import com.company.task.entity.CustomArrayValues;
import com.company.task.repository.Repository;
import com.company.task.service.findElementFromArray.FindElement;
import com.company.task.service.Sort;
import com.company.task.specification.Specification;
import com.company.task.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class RepositoryImp implements Repository {
    private static final RepositoryImp instance = new RepositoryImp();
    private List<CustomArray> repository = new ArrayList<>();

    private RepositoryImp() {
    }

    public static RepositoryImp getInstance() {
        return instance;
    }

    public List<CustomArray> query(Specification specification) {
        List<CustomArray> customArrays = new ArrayList<>();
        for (CustomArray element : repository) {
            if (specification.recognize(element)) {
                customArrays.add(element);
            }
        }
        return new ArrayList<>();
    }

    public void setRepository(List<CustomArray> repository) {
        this.repository = repository;
    }

    public List<CustomArray> getRepository() {
        return repository;
    }

    public void add(CustomArray customArray) {
        repository.add(customArray);
        addToWarehouse(customArray);
    }

    public void delete(int id) {
        repository.removeIf(array -> array.getId() == id);
    }

    @Override
    public void sort(Sort sort) {
        for (CustomArray customArray: repository){
            sort.sortArray(customArray);
        }
    }

    public void addToWarehouse(CustomArray customArray) {
        FindElement find = new FindElement(customArray);
        int id = customArray.getId();
        int sum = find.findSumOfElement();
        int average = find.findAverageOfElement();
        int min = find.findMin();
        int max = find.findAverageOfElement();
        CustomArrayValues values = new CustomArrayValues(id, sum, average, min, max);
        Warehouse.getInstance().add(id, values);
    }

    @Override
    public int hashCode() {
        return repository != null ? repository.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RepositoryImp.class.getSimpleName() + "[", "]")
                .add("storage=" + repository)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepositoryImp that = (RepositoryImp) o;

        return Objects.equals(repository, that.repository);
    }
}
