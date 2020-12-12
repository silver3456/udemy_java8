package com.udemy.java.calculator;

public class TestCalculator {
    public static void main(String[] args) {

//        String exp = "5 + 2 - 3 * 7 + 2 / 3";
        String exp = "9 * 9 - 1 * 7 / 8 + 30 ^ 2 % 3"; // we can add operation on the fly

        Calculator.addOperation("^", (a, b) -> (int)Math.pow(a , b));
        Calculator.addOperation("%", (a, b) -> a % b);



        System.out.println(

                Calculator.calculate(exp)
        );

    }
}
