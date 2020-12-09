package com.udemy.java.predicate;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateRules {


    private static final Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() == 0;

    private static final Predicate<WebElement> isContainsS = (e) -> e.getText().toLowerCase().contains("s");


    public static List<Predicate<WebElement>> get() {
        List<Predicate<WebElement>> list = new ArrayList<>();
        list.add(isBlank);
        list.add(isContainsS);
        return list;
    }



}
