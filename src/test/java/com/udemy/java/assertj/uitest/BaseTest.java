package com.udemy.java.assertj.uitest;

import com.udemy.java.assertj.assertion.PageAssert;
import com.udemy.java.assertj.assertion.WebElementAssert;
import com.udemy.java.assertj.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import sun.jvm.hotspot.debugger.Page;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    protected WebElementAssert assertThat(WebElement element) {
        return WebElementAssert.assertThat(element);
    }

    protected PageAssert assertThat(BasePage basePage) {
        return PageAssert.assertThat(basePage);
    }

    @AfterTest
    public void quit() {
        this.driver.quit();
    }

}
