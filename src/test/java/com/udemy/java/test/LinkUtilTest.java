package com.udemy.java.test;

import com.udemy.java.util.LinkUtil;

public class LinkUtilTest {

    public static void main(String[] args) {

        System.out.println(

                LinkUtil.getResponseCode("https://www.google.com")
        );
    }
}
