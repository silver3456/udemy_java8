package com;


import java.util.ArrayList;
import java.util.List;

public class FlatMapTesting {

    /*
    Use flatMap() when we want to access each element in
    the list of list

    [1,2,3]
    [4,5,6]
    [7,8,9]

    We want to access each element, not just the whole list
    lik [1,2,3]
     */

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(3);

        b.add(4);
        b.add(5);
        b.add(6);

        c.add(7);
        c.add(8);
        c.add(9);

        List<List<Integer>> list = new ArrayList<>();

        list.add(a);
        list.add(b);
        list.add(c);

        list.stream()
                .flatMap(l -> l.stream()) //create stream for each list
                .forEach(l -> System.out.println(l));


    }

}
