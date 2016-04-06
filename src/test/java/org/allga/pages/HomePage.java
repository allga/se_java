package org.allga.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/*
 */
public class HomePage extends InternalPage {

    @FindBy(css = "a[href=\"./?go=add\"]")
    private WebElement addMovieButton;

    @FindBy(css = "div.movie_box")
    private WebElement movie;

    @FindBy(css = "div.title")
    private List<WebElement> movies;

    @FindBy(id = "q")
    private WebElement searchInput;

    public HomePage(PageManager pages) {
        super(pages);
    }

    public List<WebElement> getMovies() {
        return movies;
    }

    public AddPage clickAddMovie() {
        addMovieButton.click();
        return pages.addPage;
    }

    public MoviePage openMovie(int index) {
        movies.get(index).click();
        return pages.moviePage;
    }

    public HomePage searchByTitle(String  title) {
        WebElement oldResult = movie;
        searchInput.clear();
        searchInput.sendKeys(title);
        searchInput.sendKeys(Keys.ENTER);
        wait.until(stalenessOf(oldResult));
        return this;
    }
    public HomePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("results")));
        wait.until(presenceOfAllElementsLocatedBy(By.cssSelector("div.movie_box")));
        return this;
    }

}
