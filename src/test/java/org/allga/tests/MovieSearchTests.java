package org.allga.tests;

import org.allga.model.MovieData;
import org.testng.annotations.Test;

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
    }
}
