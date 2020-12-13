package com.udemy.java.test;

import com.udemy.java.supplier.DriverFactory;
import com.udemy.java.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void linkTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .forEach(src -> {
                            System.out.println(LinkUtil.getResponseCode(src) + " :: " + src);
                        }

                            );


    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
