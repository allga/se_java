package org.allga.tests;

import org.allga.model.MovieData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;


/**
 * Created by Olga on 30.03.2016.
 */
public class MovieSearchTests extends TestBase {

    @Test
    public void testFoundMovies() {
        app.getNavigationHelper().goToHomePage();
        final String title = app.getMovieHelper().getAllMovies().get(0).getTitle();
        app.getMovieHelper().searchMovies(title);
        List<MovieData> searchResult = app.getMovieHelper().getAllMovies();

        assertTrue(searchResult.size() > 0);

        for (MovieData m : searchResult) {
            assertThat(m.getTitle(), containsString(title));
        }
    }

    @Test
    public void testNotFoundMovies() {
        app.getNavigationHelper().goToHomePage();
        final String unrealTitle = "000000000000";

        assertThat(app.getMovieHelper().searchMotFound(unrealTitle), equalTo("No movies where found."));
    }
}
