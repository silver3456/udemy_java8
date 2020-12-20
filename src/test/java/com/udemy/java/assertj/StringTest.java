package com.udemy.java.assertj;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class StringTest {


    @Test(dataProvider = "getData")
    public void stringTest(String input) {
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(input)
                    .hasSize(8)
                    .startsWith("se")
                    .doesNotContain("api")
                    .doesNotContainAnyWhitespaces()
                    .containsOnlyOnce("i");
        });

    }

    @DataProvider
    public Object[] getData() {
        return new String[]{
                "selenium",
                "selenide",
                "restapi"
        };
    }
}
