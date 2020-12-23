package com.udemy.java.assertj.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class ListIndivItemTest {

    @Test(dataProvider = "getData")
    public void listTest(List<String> input) {
        List<String> expected = Arrays.asList("apple", "ball");
        assertThat(input)
                .hasSize(3)
                .doesNotContain("cat")
                .containsAll(expected)
                .allSatisfy(str -> assertThat(str.length()).isGreaterThanOrEqualTo(4)); //another approach to verify each item

//        input.forEach(str -> assertThat(str.length()).isGreaterThanOrEqualTo(4)); //approach to verify each item
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                Arrays.asList("ball", "apple", "car")
        };
    }
}
