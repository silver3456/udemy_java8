package com.udemy.java.test;

import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class CheckBoxAssignment {
    private WebDriver driver;
    private static final String URL = "https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html";

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void selectCheckBoxValidation() {
        this.driver.navigate().to(URL);
        this.driver.findElements(By.cssSelector("input[type='checkbox']"))
                .stream()
                .forEach(WebElement::click);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
