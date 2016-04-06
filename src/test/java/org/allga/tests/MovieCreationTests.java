package org.allga.tests;

import org.allga.model.MovieData;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieCreationTests extends TestBase {

    @Test
    public void testPositiveCreationMovie() {
        app.getNavigationHelper().goToHomePage();
        List<MovieData> moviesBefore = app.getMovieHelper().getAllMovies();

        app.getNavigationHelper().goToAddMoviePage();
        MovieData movie = new MovieData().setNumber("0711111").setTitle("Miles Ahead").setYear("2015").setDuration("100");
        app.getMovieHelper().createMovie(movie);

        assertThat(app.getMovieHelper().isMovieSaved(), equalTo(true));

        app.getNavigationHelper().goToHomePage();
        List<MovieData> moviesAfter = app.getMovieHelper().getAllMovies();

        assertThat(moviesAfter.size(), equalTo(moviesBefore.size() + 1));

    }

    @Test
    public void testRequiredFieldCreationMovie() {
        app.getNavigationHelper().goToHomePage();
        List<MovieData> moviesBefore = app.getMovieHelper().getAllMovies();

        app.getNavigationHelper().goToAddMoviePage();
        MovieData movie = new MovieData().setTitle("The Game");
        app.getMovieHelper().createMovie(movie);

        assertThat(app.getMovieHelper().isFieldRequired(), equalTo(true));
        assertThat(app.getMovieHelper().isMovieSaved(), equalTo(false));

        app.getNavigationHelper().goToHomePage();
        List<MovieData> moviesAfter = app.getMovieHelper().getAllMovies();

        assertThat(moviesAfter.size(), equalTo(moviesBefore.size()));
    }

}
