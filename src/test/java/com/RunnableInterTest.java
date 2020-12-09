package com;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class RunnableInterTest {
    public static void main(String[] args) {

        Runnable r = () -> {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            System.out.println("hello World");
        };

        //create a new thread. class Thread accepts Runnable interface
        new Thread(r).start();

        //this executes first
        System.out.println("Hi");
    }
}
