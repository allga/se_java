package org.allga.tests;

import org.allga.model.MovieData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieDeletionTests extends TestBase {

    @Test
    public void testDeletionMovie()  {
        app.getNavigationHelper().goToHomePage();
        List<MovieData> moviesBefore = app.getMovieHelper().getAllMovies();

        app.getMovieHelper().allMovies().get(0).click();
        app.getMovieHelper().deleteMovie();

        (new WebDriverWait(app.getDriver(), 5)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

        app.getNavigationHelper().goToHomePage();
        List<MovieData> moviesAfter = app.getMovieHelper().getAllMovies();
        assertThat(moviesAfter.size(), equalTo(moviesBefore.size() - 1));
    }

}
