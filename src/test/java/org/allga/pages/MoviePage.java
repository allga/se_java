package org.allga.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Olga on 06.04.2016.
 */
public class MoviePage extends AnyPage {

    @FindBy(xpath = "//a[.//img[@title=\"Remove\"]]")
    private WebElement removeButton;

    public MoviePage(PageManager pages) {
        super(pages);
    }

    public HomePage clickRemoveButton() {
        removeButton.click();
        driver.switchTo().alert().accept();
        return pages.homePage;
    }

    public MoviePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("movie")));
        return this;
    }
}
