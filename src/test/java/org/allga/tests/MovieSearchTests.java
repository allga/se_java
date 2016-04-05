package org.allga.tests;

import org.allga.model.MovieData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Olga on 30.03.2016.
 */
public class MovieSearchTests extends TestBase {

    @Test
    public void testFoundMovies() {
        app.getNavigationHelper().goToHomePage();
        MovieData movie = app.getMovieHelper().getAllMovies().get(0);
        final String title = movie.getTitle();
        boolean result = app.getMovieHelper().foundMovies(title);
        assertThat(result, equalTo(true));
        List<MovieData> searchResult = app.getMovieHelper().getAllMovies();
        for (MovieData m : searchResult) {
            assertThat(m.getTitle(), containsString(title));
        }
    }

    @Test
    public void testNotFoundMovies() {
        app.getNavigationHelper().goToHomePage();
        final String unrealTitle = "000000000000";
        boolean result = app.getMovieHelper().foundMovies(unrealTitle);
        assertThat(result, equalTo(false));
        String founded = app.getDriver().findElement(By.cssSelector("div.content")).getText();
        assertThat(founded, equalTo("No movies where found."));
    }
}
