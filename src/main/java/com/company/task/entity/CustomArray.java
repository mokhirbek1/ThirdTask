package com.company.task.entity;

import com.company.task.creator.CustomArrayCreator;
import com.company.task.exception.TaskException;
import com.company.task.observer.Observable;
import com.company.task.observer.Observer;
import com.company.task.observer.impl.CustomArrayObserver;
import com.company.task.repository.impl.RepositoryImp;
import com.company.task.warehouse.Warehouse;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class CustomArray implements Observable {
    private int id;
    private int size;
    private int[] customArray;
    private boolean sorted = false;
    private Observer observer = new CustomArrayObserver();

    public CustomArray(int id) {
        this.id = id;
    }

    public CustomArray(int[] customArray, int id) {
        this.customArray = customArray;
        this.id = id;
    }

    public void setSize(int size) throws TaskException{
        if (size<0){
            throw new TaskException("Size don't match");
        }
        this.size = size;
    }

    public void setId(int id) throws TaskException {
        if (id < 0) {
            throw new TaskException("id is less than zero");
        }
        this.id = id;
    }

    public void setElement(int element, int index) throws TaskException {
        if (checkIndex(index)) {
            customArray[index] = element;
        } else {
            throw new TaskException("Invalid index");
        }
    }

    public void setSorted(boolean value) {
        sorted = value;
    }


    public int[] getArray() {
        return customArray;
    }


    public int getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public boolean isSorted() {
        return sorted;
    }

    public int getElement(int index) {
        return this.customArray[index];
    }

    public boolean checkIndex(int index) {
        return index >= 0 && index < this.getSize();
    }

    @Override
    public void attach(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void detach(Observer observer) {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        observer.actionPerformed(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return id == that.id && sorted == that.sorted && Arrays.equals(customArray, that.customArray) && Objects.equals(observer, that.observer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, sorted, observer);
        result = 31 * result + Arrays.hashCode(customArray);
        return result;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",").add("CustomArray{")
                .add("id=" + id)
                .add(", customArray=" + Arrays.toString(customArray))
                .add(", sorted=" + sorted)
                .add(", observer=" + observer)
                .add("}");
        return joiner.toString();
    }
}
