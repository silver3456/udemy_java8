package com.udemy.java.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class UdemyHomePageTest {

    private WebDriver driver;
    private Actions actions;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.actions = new Actions(driver);
    }


    @Test(dataProvider = "linkProvider")
    public void dropdownTest(String path) {
        this.driver.get("https://www.udemy.com/");
        WebElement el = driver.findElement(By.xpath("//span[text()='Categories']"));
        actions.moveToElement(el).perform();

        String[] split = path.split("=>");
        Arrays.stream(split)
                .map(s -> s.trim())
                .map((s -> By.xpath("//div[text()='"+ s + "']")))
                .map(by -> driver.findElement(by))// use by to find the WebElement
                .map(elem -> actions.moveToElement(elem))
                .forEach(a -> a.perform());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }

    @DataProvider(name = "linkProvider")
    public Object[] testData() {
        return new Object[]{
                "Development => Web Development => JavaScript",
                "Business => Management => Leadership"
        };
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
