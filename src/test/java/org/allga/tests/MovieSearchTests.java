package org.allga.tests;

import org.allga.model.MovieData;
import org.testng.annotations.Test;

import java.util.List;

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
        List<MovieData> foundMovies = getMovieHelper().searchMovie(movie.getTitle());
 //       foundMovies.stream().;
        assertThat(foundMovies.size(), not(0));
    }

    @Test
    public void testNotFoundMovies() {

    }
}
