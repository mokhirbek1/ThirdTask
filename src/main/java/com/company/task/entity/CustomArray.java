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

public class CustomArray implements Observable {
    private int id;
    private int size;
    private int[] customArray;
    private boolean sorted = false;
    private Observer observer = new CustomArrayObserver();

    public CustomArray(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public CustomArray(int[] customArray, int id) {
        this.customArray = customArray;
        size = customArray.length;
        this.id = id;
    }

    public void setId(int id) throws TaskException {
        if (id < 0) {
            throw new TaskException("id is less than zero");
        }
        this.id = id;
    }

    public void setSize(int size) throws TaskException {
        if (size > 0) {
            this.size = size;
            customArray = new int[this.size];
        } else {
            throw new TaskException("size does not match");
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return size == that.size && sorted == that.sorted && Arrays.equals(customArray, that.customArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, sorted);
        result = 31 * result + Arrays.hashCode(customArray);
        return result;
    }

    @Override
    public String toString() {
        return "CustomArray{" +
                "id= " + id +
                ", size=" + size +
                ", customArray=" + Arrays.toString(customArray) +
                ", sorted=" + sorted +
                '}';
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

}
