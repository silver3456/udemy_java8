package com.udemy.java.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.assignment.PaymentScreenPage;
import com.udemy.java.pages.TableDemoPage;
import com.udemy.java.supplier.DriverFactory;
import com.udemy.java.supplier.SearchCriteriaFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.udemy.java.test.PaymentScreenActions.*;

public class PaymentScreenTest {

    private WebDriver driver;
    private PaymentScreenPage paymentScreenPage;



    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.paymentScreenPage = new PaymentScreenPage(driver);
    }


    @Test(dataProvider = "criteriaProvider")
    public void paymentScreenTest(Consumer<PaymentScreenPage> consumer) {
     paymentScreenPage.goTo();
     consumer.accept(paymentScreenPage);

     Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider(name = "criteriaProvider")
    public Object[] testData() {
        return new Object[] {
           valiadCC.andThen(buy).andThen(successfulPurchase),
           freeCoupon.andThen(buy).andThen(successfulPurchase),
           discountedCoupon.andThen(valiadCC).andThen(buy).andThen(successfulPurchase),
           invaliadCC.andThen(buy).andThen(failedPurchase),
           invaliadCC.andThen(discountedCoupon).andThen(buy).andThen(failedPurchase),
           buy.andThen(failedPurchase)

        };
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
