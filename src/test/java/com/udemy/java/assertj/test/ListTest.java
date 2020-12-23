package com.udemy.java.assertj.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class ListTest {

    @Test(dataProvider = "getData")
    public void listTest(List<String> input) {
        List<String> expected = Arrays.asList("apple", "ball");
        assertThat(input)
                .hasSize(3)
                .doesNotContain("cat")
                .containsAll(expected);

    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                Arrays.asList("ball", "apple", "car")
        };
    }
}
