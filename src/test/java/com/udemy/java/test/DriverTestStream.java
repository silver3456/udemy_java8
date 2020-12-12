package com.udemy.java.test;

import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;

public class DriverTestStream {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
       this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void googleTest() {
        this.driver.get("https://google.com");
        List<WebElement> elements = this.driver.findElements(By.tagName("a"));
//                .forEach(e -> System.out.println(e.getText()));

        Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() == 0;

        System.out.println("Before:: " + elements.size());

        elements.removeIf(isBlank);

        System.out.println("After:: " + elements.size());

        elements.forEach(e -> System.out.println(e.getText()));
    }

    //do not allow blank links
    //do not allow links containing s
    //convert link text to uppercase
    //print on the console
    @Test
    public void googleTest2() {
        this.driver.get("https://google.com");
        this.driver.findElements(By.tagName("a"))
                .stream()
                .filter(e -> e.getText().trim().length() > 0)
                .filter(el -> !el.getText().toLowerCase().contains("s"))
                .map(e -> e.getText().toUpperCase())
                .forEach(System.out::println);
    }

    @Test
    public void googleTestImproved() {
        this.driver.get("https://google.com");
        this.driver.findElements(By.tagName("a"))
                .stream()
                .map(WebElement::getText) //convert to the stream of String
                .map(String::trim)
                .filter(e -> e.length() > 0)
                .filter(el -> !el.toLowerCase().contains("s"))
                .map(String :: toUpperCase)
                .forEach(System.out::println);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }


}
