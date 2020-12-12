package com.udemy.java.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamTask2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        //1. check for even numbers
        //2. ensure that number > 5
        //3. find the square and add 2 to that
        //4. print in on console one by one - new line


        list.stream()
                .filter(i -> i % 2 == 0)
                .filter(i -> i > 5)
                .map((i) -> i * i)
                .map(i -> i + 2)
                .forEach(i -> System.out.println(i));
    }
}