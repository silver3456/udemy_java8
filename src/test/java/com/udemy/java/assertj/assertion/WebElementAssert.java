package com.udemy.java.assertj.assertion;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    public WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement element) {
        return new WebElementAssert(element);
    }

    public WebElementAssert isDisplayed() {
        isNotNull();
        if (!actual.isDisplayed()) {
            failWithMessage("Expected the element to be displayed, but it wasn't");
        }
        return this;
    }

    public WebElementAssert isEnabled() {
        isNotNull();
        if (!actual.isEnabled()) {
            failWithMessage("Expected the element to be enabled, but wasn't");
        }
        return this;
    }

    //<button.../>  or  <input type = button.../>
    public WebElementAssert isButton() {
        isNotNull();
        boolean isButton = actual.getTagName().equalsIgnoreCase("button") ||
                actual.getAttribute("type").equalsIgnoreCase("button");
        if (!isButton) {
            failWithMessage("Expected element to be a button but it is not");
        }
        return this;
    }

    public WebElementAssert hasAttributeValue(String attr, String value) {
        isNotNull();
        if (!actual.getAttribute(attr).equalsIgnoreCase(value)) {
            failWithMessage("Expected element to have attr <%s> value as<%s> but wasn't", attr, value);
        }
        return this;
    }
}
