package com.company.task.service.findElementFromArray;

import com.company.task.entity.CustomArray;
import com.company.task.exception.TaskException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FindElementTest {
    FindElement find;
    CustomArray customArray;
    List<Integer> expected;
    List<Integer> actual;
    @BeforeMethod
    public void setUp() throws TaskException {
        int[] array = {6,12,88,34,1,90,33,223,2,77,3,53,154,657,478,78,5,7,21};
        customArray = new CustomArray(array, 44);
        find = new FindElement(customArray);
        expected = new ArrayList<>();
    }

    @Test
    public void testFindMax() {
        int expected = 657;
        int actual = find.findMax();
        assertEquals(actual, expected);
    }

    @Test
    public void testFindMin() {
        int expected = 1;
        int actual = find.findMin();
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllPrimeNumber() {
        expected.add(1);
        expected.add(223);
        expected.add(2);
        expected.add(3);
        expected.add(53);
        expected.add(5);
        expected.add(7);
        actual = find.findAllPrimeNumber();
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllFibonacciNumber() {
        expected.add(34);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(21);
        actual = find.findAllFibonacciNumber();
        assertEquals(actual, expected);
    }

    @Test
    public void testFindThreeDigitNumber() {
        expected.add(154);
        expected.add(657);
        expected.add(478);
        actual = find.findThreeDigitNumber();
        assertEquals(actual, expected);
    }
}