package com.udemy.java.assertj.assertion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {

    public static void main(String[] args) {
//        removeAllEvenNums();
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(integers.contains(22));

    }

    private static void removeAllEvenNums() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        for (int i : integers) {
            if(i % 2 == 0) {
                integers.remove(i);
            }
        }
    }
}
