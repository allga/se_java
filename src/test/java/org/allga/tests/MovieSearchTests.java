package org.allga.tests;

import org.allga.model.MovieData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Olga on 30.03.2016.
 */
public class MovieSearchTests extends TestBase {

    @Test
    public void testFoundMovies() {
        getNavigationHelper().goToHomePage();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.movie_box")));
        MovieData movie = getMovieHelper().getAllMovies().get(0);
        final String title = movie.getTitle();
        List<MovieData> foundMovies = getMovieHelper().searchMovie(title);
        assertThat(foundMovies.size(), not(0));
        for (MovieData m : foundMovies) {
            assertThat(m.getTitle(), equalTo(title));
        }
    }

    @Test
    public void testNotFoundMovies() {
        getNavigationHelper().goToHomePage();
        final String unrealTitle = "000000000000";
        List<MovieData> foundUnrealMovies = getMovieHelper().searchMovie(unrealTitle);
        assertThat(foundUnrealMovies.size(), equalTo(0));
        String founded = driver.findElement(By.cssSelector("div.content")).getText();
        assertThat(founded, equalTo("No movies where found."));
    }
}
