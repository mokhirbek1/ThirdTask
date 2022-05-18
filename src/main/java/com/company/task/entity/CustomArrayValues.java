package com.company.task.entity;

import java.util.Objects;

public class CustomArrayValues {
    private int id;
    private int sum;
    private int average;
    private int min;
    private int max;
    public CustomArrayValues(int id, int sum, int average, int min, int max){
        this.id = id;
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public int getAverage() {
        return average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayValues that = (CustomArrayValues) o;
        return id == that.id && sum == that.sum && average == that.average && min == that.min && max == that.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sum, average, min, max);
    }

    @Override
    public String toString() {
        return "CustomArrayValues{" +
                "id=" + id +
                ", sum=" + sum +
                ", average=" + average +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
