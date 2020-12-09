package com.udemy.java.test;

import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;

public class DriverTestPredicate {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("firefox") String browser) {
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

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }


}
