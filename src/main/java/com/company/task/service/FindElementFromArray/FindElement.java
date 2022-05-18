package com.company.task.service.FindElementFromArray;

import com.company.task.entity.CustomArray;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindElement {
    private static final Logger logger = Logger.getLogger(FindElement.class.toString());
    private CustomArray customArray;
    private int length;

    public FindElement(CustomArray customArray) {
        this.customArray = customArray;
        length = customArray.getSize();
    }

    public int findMax() {
        int maxElement = 0;
        for (int i = 0; i < length; i++) {
            if (maxElement < customArray.getElement(i)) {
                maxElement = customArray.getElement(i);
            }
        }
        return maxElement;
    }

    public int findMin() {
        int minElement = customArray.getElement(0);
        for (int i = 0; i < length; i++) {
            if (minElement > customArray.getElement(i)) {
                minElement = customArray.getElement(i);
            }
        }
        return minElement;
    }

    public List<Integer> findAllPrimeNumber() {
        List<Integer> listOfPrimeNumber = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 2; j < 10; j++) {
                if (customArray.getElement(i) == j) {
                    continue;
                } else {
                    if (customArray.getElement(i) % j != 0) {
                        if (j == 9) {
                            int value = customArray.getElement(i);
                            listOfPrimeNumber.add(value);
                        }
                    } else {
                        break;
                    }
                }

            }
        }
        return listOfPrimeNumber;
    }

    public List<Integer> findAllFibonacciNumber() {
        List<Integer> fibonacciNumberFromArray = new ArrayList<>();
        List<Integer> fibonacciNumber = createFibonacciNumber();
        int fibonacciNumberSize = fibonacciNumber.size();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < fibonacciNumberSize; j++) {
                if (customArray.getElement(i) == fibonacciNumber.get(j)) {
                    fibonacciNumberFromArray.add(customArray.getElement(i));
                }
            }
        }
        return fibonacciNumberFromArray;
    }

    private List<Integer> createFibonacciNumber() {
        List<Integer> fibonacciNumber = new ArrayList<>();
        int rangeOfArray = findMax();

        if (rangeOfArray > 0) {
            fibonacciNumber.add(0, 0);
            fibonacciNumber.add(1, 1);
            int length = rangeOfArray / 2;
            int sum;
            for (int i = 2; i < length; i++) {
                sum = 0;
                for (int j = i - 2; j < i; j++) {
                    sum += fibonacciNumber.get(j);
                }
                fibonacciNumber.add(i, sum);
                if (fibonacciNumber.get(i) > rangeOfArray) {
                    break;
                }
            }
        } else {
            logger.log(Level.WARNING, "Failed in creating Fibonacci numbers");
        }
        return fibonacciNumber;
    }

    public List<Integer> findThreeDigitNumber() {
        List<Integer> listThreeDigitNumber = new ArrayList<>();
        List<Integer> listOfFoundNumber = new ArrayList<>();
        String strings;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (i != j && i != k && j != k) {
                        strings = "";
                        strings += i;
                        strings += j;
                        strings += k;
                        listThreeDigitNumber.add(Integer.valueOf(strings));
                    }
                }
            }
        }
        int count = listThreeDigitNumber.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < count; j++) {
                if (customArray.getElement(i) == listThreeDigitNumber.get(j)) {
                    listOfFoundNumber.add(customArray.getElement(i));
                }
            }
        }
        return listOfFoundNumber;
    }

    public int findSumOfElement() {
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += customArray.getElement(i);
        }
        return result;
    }

    public int findAverageOfElement() {
        return findSumOfElement() / length;
    }

}
