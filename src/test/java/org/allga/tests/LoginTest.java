package org.allga.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() throws Exception {
        assertThat((getMovieHelper().isElementPresent(By.cssSelector("a[href*=\"php4dvd/?logout\"]"))), equalTo(true));

    }
}
