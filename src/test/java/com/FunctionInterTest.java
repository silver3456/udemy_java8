package com;

import java.util.function.Function;


//Function interface accepts 1st arg as a type and returns 2nd arg type

public class FunctionInterTest {
    public static void main(String[] args) {

        Function<Integer, Integer> plus2 = (i) -> i + 2;
        Function<Integer, Integer> square = (i) -> i * i;

        System.out.println(

                //compose will let the second func execute first and then the 1st func
                plus2.compose(square).apply(8)


        );
    }
}
