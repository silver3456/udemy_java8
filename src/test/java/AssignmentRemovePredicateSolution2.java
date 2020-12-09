import com.udemy.java.predicate.PredicateRules;
import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;

public class AssignmentRemovePredicateSolution2 {
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

        System.out.println("Before:: " + elements.size());

//        PredicateRules.get().forEach(rule -> elements.removeIf(rule));

        PredicateRules.get().forEach(elements::removeIf);

        System.out.println("After:: " + elements.size());

        elements.forEach(e -> System.out.println(e.getText()));
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }


}
