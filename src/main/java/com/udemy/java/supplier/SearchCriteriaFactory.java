package com.udemy.java.supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SearchCriteriaFactory {

    private static Predicate<List<WebElement>> allMale = (l) -> l.get(1).getText().equalsIgnoreCase("male");
    private static Predicate<List<WebElement>> allFemale = (l) -> l.get(1).getText().equalsIgnoreCase("female");
    private static Predicate<List<WebElement>> allGender = allMale.or(allFemale);
    private static Predicate<List<WebElement>> usaOnly = (l) -> l.get(2).getText().equalsIgnoreCase("usa");
    private static Predicate<List<WebElement>> femaleFromUSA = allFemale.and(usaOnly);


    private static final Map<String, Predicate<List<WebElement>>> MAP = new HashMap<>();

    static {
        MAP.put("allMale", allMale);
        MAP.put("allFemale", allFemale);
        MAP.put("allGender", allGender);
        MAP.put("usaOnly", usaOnly);
        MAP.put("femaleFromUSA", femaleFromUSA);
    }

    public static Predicate<List<WebElement>> getCriteria(String criteria) {
        return MAP.get(criteria);
    }
}
