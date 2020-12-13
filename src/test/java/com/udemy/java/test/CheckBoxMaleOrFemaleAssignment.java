package com.udemy.java.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.pages.TableDemoPage;
import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class CheckBoxMaleOrFemaleAssignment {
    private WebDriver driver;
    private TableDemoPage tableDemoPage;

    private static final String URL = "https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html";


    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.tableDemoPage = new TableDemoPage(driver);
    }

    @Test
    public void selectCheckBoxValidation() {
        this.driver.navigate().to(URL);
        this.driver.findElements(By.cssSelector("input[type='checkbox']"))
                .stream()
                .forEach(WebElement::click);
    }

    @Test(dataProvider = "testData")
    public void selectCheckBoxGenderValidation(String gender) {
        this.driver.navigate().to(URL);
        this.driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)//skip the first row
                .map(tr -> tr.findElements(By.tagName("td")))//find all td inside tr
                .filter(tdList -> tdList.size() == 4)// make sure that the table has 4 td (not empty) before it proceeds
                .filter(tdList -> tdList.get(1).getText().equalsIgnoreCase(gender))//check gender by accessing second td inside tr
                .map(tdList -> tdList.get(3)) // list of td containing checkbox
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS); // sleep for a sec to see what's happening
    }

    @Test(dataProvider = "testData")
    public void selectCheckBoxGenderImprovedValidation(String gender){
        tableDemoPage.goTo();
        tableDemoPage.selectRows(gender);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS); // sleep for a sec to see what's happening

    }

    @Test(dataProvider = "criteriaProvider")
    public void testSelectCheckBoxImprovedWithPredicate(Predicate<List<WebElement>> searchCriteria) {
        tableDemoPage.goTo();
        tableDemoPage.selectGenericRows(searchCriteria);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS); // sleep for a sec to see what's happening

    }

    @DataProvider(name = "gender")
    public Object[] testData() {
        return new Object[] {
                "male",
                "female"
        };
    }

    @DataProvider(name = "criteriaProvider")
    public Object[] testData2() {
        //l.get(1) --> give me the 2nd cell
        Predicate<List<WebElement>> allMale = (l) -> l.get(1).getText().equalsIgnoreCase("male");
        Predicate<List<WebElement>> allFemale = (l) -> l.get(1).getText().equalsIgnoreCase("female");
        Predicate<List<WebElement>> allGender = allMale.or(allFemale);
        Predicate<List<WebElement>> usaOnly = (l) -> l.get(2).getText().equalsIgnoreCase("usa");
        Predicate<List<WebElement>> femaleFromUSA = allFemale.and(usaOnly);

        return new Object[] {
                allMale,
                allFemale,
                allGender,
                usaOnly,
                femaleFromUSA
        };
    }



    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
