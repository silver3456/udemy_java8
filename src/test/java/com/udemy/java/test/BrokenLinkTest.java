package com.udemy.java.test;

import com.udemy.java.supplier.DriverFactory;
import com.udemy.java.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void testBrokenImages() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .forEach(src -> {
                            System.out.println(LinkUtil.getResponseCode(src) + " :: " + src);
                        }
                );

    }

    @Test
    public void testBrokenLinks() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .map(e -> e.getAttribute("href"))
                .forEach(src -> {
                            System.out.println(LinkUtil.getResponseCode(src) + " :: " + src);
                        }
                );

    }

    @Test
    public void testBrokenImagesImproved() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        boolean result = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .map(src -> LinkUtil.getResponseCode(src))
                .anyMatch(rc -> rc != 200);

        Assert.assertFalse(result);
    }


    @Test
    public void testBrokenImagesWithStackTrace() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        List<String> list = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());// create a new list that stores broken images

        Assert.assertEquals(list.size(), 0, list.toString());
    }

    @Test
    public void testBrokenImagesCollector() {
        this.driver.get("https://www.google.com");

        System.out.println("Before :: " + LocalDateTime.now());

        List<String> list = this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel()
                .map(e -> e.getAttribute("href"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());// create a new list that stores broken images

        System.out.println("After :: " + LocalDateTime.now());


    }


    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
