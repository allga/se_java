package org.allga.helpers;

import org.allga.model.MovieData;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieHelper extends HelperBase {

    private boolean acceptNextAlert;

    public MovieHelper(WebDriver driver) {
        super(driver);
        acceptNextAlert = true;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void fillMovieForm(MovieData movie) {
        type(By.name("imdbid"), movie.getNumber());
        type(By.name("name"), movie.getTitle());
        type(By.name("year"), movie.getYear());
        type(By.name("duration"), movie.getDuration());
    }

    public List<WebElement> allMovies() {
        return new ArrayList<WebElement>(driver.findElements(By.cssSelector("div.movie_box")));
    }

    public List<MovieData> getAllMovies() {
        List<MovieData> movies = new ArrayList<MovieData>();
        List<WebElement> elements = new ArrayList<WebElement>(driver.findElements(By.cssSelector("div.movie_box")));
        for (WebElement el : elements) {
            String title = el.findElement(By.cssSelector("div.title")).getText();
            movies.add(new MovieData().setTitle(title));
        }
        return movies;
    }

    public int countAllMovies() {
        return allMovies().size();
    }

    public void deleteMovie() {
        click(By.xpath("//*[@class='button']//a[.//img[@title=\"Remove\"]]"));
        driver.switchTo().alert().accept();
    }


    public void submitCreationMovie() {
        click(By.name("submit"));
    }

    public List<MovieData> searchMovie(String movie) {
        type(By.id("q"), movie);
        submitSearch();
        driver.navigate().refresh();
        return getAllMovies();
    }

    private void submitSearch() {
        driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
    }
}
