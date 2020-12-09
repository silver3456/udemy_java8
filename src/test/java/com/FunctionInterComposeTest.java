package com;

import java.util.function.Function;


//Function interface accepts 1st arg as a type and returns 2nd arg type

public class FunctionInterComposeTest {
    public static void main(String[] args) {

        Function<String, Integer> strLen = (s) -> s.length();
        Function<Integer, Integer> square = (i) -> i * i;

        System.out.println(

//                strLen.apply("hello alex")
                strLen.andThen(square).apply("hello alex")


        );
    }
}
