package com.udemy.java.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxMaleOrFemaleAssignment {
    private WebDriver driver;
    private static final String URL = "https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html";

//    List<WebElement> checkboxes = this.driver.findElements(By.cssSelector("input[type='checkbox']"));
//    List<WebElement> male = this.driver.findElements(By.xpath("//td[text() = 'Male']"));
//    List<WebElement> female = this.driver.findElements(By.xpath("//td[text() = 'Female']"));
//    List<WebElement> rows = this.driver.findElements(By.xpath("//tr"));


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

    @Test(dataProvider = "gender")
    public void selectCheckBoxGenderValidation(String gender) {
        this.driver.navigate().to(URL);
        this.driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)//skip the first row
                .map(tr -> tr.findElements(By.tagName("td")))//find all td inside tr
                .filter(tdList -> tdList.get(1).getText().equalsIgnoreCase(gender))//check gender by accessing second td inside tr
                .map(tdList -> tdList.get(3)) // list of td containing checkbox
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS); // sleep for a sec to see what's happening
    }

    @DataProvider(name = "gender")
    public Object[] testDate() {
        return new Object[] {
                "male",
                "female"
        };
    }


    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
