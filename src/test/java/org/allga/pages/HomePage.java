package org.allga.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/*
 */
public class HomePage extends InternalPage {

    @FindBy(css = "a[href=\"./?go=add\"]")
    private WebElement addMovieButton;

    public HomePage(PageManager pages) {
        super(pages);
    }

    public AddPage clickAddMovie() {
        addMovieButton.click();
        return pages.addPage;
    }

    public HomePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("results")));
        wait.until(presenceOfAllElementsLocatedBy(By.cssSelector("div.movie_box")));
        return this;
    }

}
