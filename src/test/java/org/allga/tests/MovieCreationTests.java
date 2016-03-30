package org.allga.tests;

import org.allga.model.MovieData;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieCreationTests extends TestBase {

    @Test
    public void testPositiveCreationMovie() {
        getNavigationHelper().goToHomePage();
        int before = getMovieHelper().countAllMovies();

        getNavigationHelper().goToAddMoviePage();
        MovieData movie = new MovieData().setNumber("0711111").setTitle("Miles Ahead").setYear("2015").setDuration("100");
        getMovieHelper().fillMovieForm(movie);
        getMovieHelper().submitCreationMovie();
        assertThat((driver.getCurrentUrl()), containsString("php4dvd/?go=movie&id="));

        getNavigationHelper().goToHomePage();
        int after = getMovieHelper().countAllMovies();
        assertThat(after, equalTo(before + 1));

    }

    @Test
    public void testRequiredFieldCreationMovie() {
        getNavigationHelper().goToHomePage();
        int before = getMovieHelper().countAllMovies();

        getNavigationHelper().goToAddMoviePage();
        MovieData movie = new MovieData().setNumber("0711111").setYear("2015").setDuration("100");
        getMovieHelper().fillMovieForm(movie);
        getMovieHelper().submitCreationMovie();
        assertThat((driver.getCurrentUrl()), containsString("php4dvd/?go=add"));

        getNavigationHelper().goToHomePage();
        int after = getMovieHelper().countAllMovies();
        assertThat(after, equalTo(before));
    }

}
