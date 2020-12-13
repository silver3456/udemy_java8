package com.udemy.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;

public class TableDemoPage {
    private final WebDriver driver;

    private static final String URL = "https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html";

    public TableDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get(URL);
    }

    public void selectRows(String gender) {
        this.driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)//skip the first row
                .map(tr -> tr.findElements(By.tagName("td")))//find all td inside tr
                .filter(tdList -> tdList.size() == 4)// make sure that the table has 4 td (not empty) before it proceeds
                .filter(tdList -> tdList.get(1).getText().equalsIgnoreCase(gender))//check gender by accessing second td inside tr
                .map(tdList -> tdList.get(3)) // list of td containing checkbox
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
    }

    public void selectGenericRows(Predicate<List<WebElement>> predicate) {
        this.driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)//skip the first row
                .map(tr -> tr.findElements(By.tagName("td")))//find all td inside tr
                .filter(tdList -> tdList.size() == 4)// make sure that the table has 4 td (not empty) before it proceeds
                .filter(predicate)//check gender by accessing second td inside tr
                .map(tdList -> tdList.get(3)) // list of td containing checkbox
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
    }
}
