package com.udemy.java.assertj.assertion;

import com.udemy.java.assertj.pages.BasePage;
import org.assertj.core.api.AbstractAssert;

public class PageAssert extends AbstractAssert<PageAssert, BasePage> {


    public PageAssert(BasePage basePage) {
        super(basePage, PageAssert.class);
    }

    public static PageAssert assertThat(BasePage page) {
        return new PageAssert(page);
    }

    public PageAssert isAt() {
        isNotNull();
        if (!actual.isAt()) {
            failWithMessage("Page is not displayed");
        }
        return this;
    }
}
