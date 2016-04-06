package org.allga.helpers;

import org.allga.model.MovieData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieHelper extends BaseHelper {

    public MovieHelper(ApplicationManager manager) {
        super(manager.getDriver());
    }

    public boolean isLoggedIn (){
        return pages.internalPage.waitPageLoaded();
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void fillMovieForm(MovieData movie) {
        pages.addPage.setTitle(movie.getTitle());
        pages.addPage.setYear(movie.getYear());
    }

    public List<WebElement> allMovies() {
        return pages.homePage.ensurePageLoaded().getMovies();
    }

    public void openDeletedMovie(int index) {
        pages.homePage.ensurePageLoaded().openMovie(index).ensurePageLoaded();
    }

    public List<MovieData> getAllMovies() {
        List<MovieData> movies = new ArrayList<MovieData>();
        for (WebElement el : allMovies()) {
            String title = el.getText();
            movies.add(new MovieData().setTitle(title));
        }
        return movies;
    }

    public void deleteMovie() {
        pages.moviePage.clickRemoveButton().ensurePageLoaded();
    }


    public void submitCreationMovie() {
        pages.addPage.clickSubmit();
    }

    public boolean foundMovies(String movie) {
        type(By.id("q"), movie);
        WebElement oldResult = driver.findElement(By.cssSelector("div.title"));
        submitSearch();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(oldResult)); //ждем исчезновения старых результатов

        try {
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.title"))); //ждем появления новых результатов
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    private void submitSearch() {
        driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
    }

}
