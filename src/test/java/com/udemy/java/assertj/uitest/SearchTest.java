package com.udemy.java.assertj.uitest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.assertj.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class SearchTest extends BaseTest{

    private SearchPage searchPage;

    @BeforeTest
    public void pageSetup() {
        this.searchPage = new SearchPage(driver);
    }

    //placeholder="Search the web without being tracked"
    @Test(enabled = false)
    public void searchTest() {
        driver.get("https://www.duckduckgo.com");
        WebElement element = this.driver.findElement(By.name("q"));

        assertThat(element).isDisplayed()
//                .isButton()
                .hasAttributeValue("placeholder", "Search the web without being tracked")
                .isEnabled();
    }

    //Improvement of the test above
    @Test
    public void launchSite() {
        this.searchPage.goTo();
//        Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
        assertThat(this.searchPage).isAt();
    }

    @Test(dependsOnMethods = "launchSite")
    public void keywordTest() {
        this.searchPage.search("vinsguru");
        assertThat(this.searchPage.getSearchBox())
                .isEnabled()
                .isDisplayed()
                .hasAttributeValue("value", "vinsguru");
    }
}
