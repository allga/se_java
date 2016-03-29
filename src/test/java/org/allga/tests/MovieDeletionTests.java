package org.allga.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieDeletionTests extends TestBase {

    @Test
    public void testDeletionMovie() {
        List<WebElement> before = new ArrayList<WebElement>(driver.findElements(By.cssSelector("div.movie_box")));
        before.get(0).click();
        movieHelper.click(By.xpath("//*[@class='button']//a[.//img[@title=\"Remove\"]]"));
        driver.switchTo().alert().accept();
        List<WebElement> after = new ArrayList<WebElement>(driver.findElements(By.cssSelector("a[href*=\"go=movie&id\"]")));
        assertThat(after.size(), equalTo(before.size() - 1));
    }

}
