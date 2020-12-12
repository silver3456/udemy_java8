package com.udemy.java.stream;

import java.util.ArrayList;
import java.util.List;

public class EvenNumbersStreamTask {
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
        //2. interested only in 3 elements
        //3. find the square
        //4. print in on console one by one - new line


        list.stream()
                .filter(i -> i % 2 == 0)
                .limit(3)
                .map((i) -> i * i)
                .forEach(i -> System.out.println(i));
    }
}
