package org.allga.tests;

import org.allga.model.MovieData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
        List<MovieData> moviesBefore = getMovieHelper().getAllMovies();

        getNavigationHelper().goToAddMoviePage();
        MovieData movie = new MovieData().setNumber("0711111").setTitle("Miles Ahead").setYear("2015").setDuration("100");
        getMovieHelper().fillMovieForm(movie);
        getMovieHelper().submitCreationMovie();

        assertThat((driver.getCurrentUrl()), containsString("php4dvd/?go=movie&id="));

        getNavigationHelper().goToHomePage();
        List<MovieData> moviesAfter = getMovieHelper().getAllMovies();

        assertThat(moviesAfter.size(), equalTo(moviesBefore.size() + 1));

    }

    @Test
    public void testRequiredFieldCreationMovie() {
        getNavigationHelper().goToHomePage();
        List<MovieData> moviesBefore = getMovieHelper().getAllMovies();

        getNavigationHelper().goToAddMoviePage();
        MovieData movie = new MovieData().setNumber("0711111").setTitle("The Game").setDuration("100");
        getMovieHelper().fillMovieForm(movie);
        getMovieHelper().submitCreationMovie();
        boolean requiredFild = getMovieHelper().isElementPresent(By.cssSelector("input.error"));

        assertThat(requiredFild, equalTo(true));

        getNavigationHelper().goToHomePage();
        List<MovieData> moviesAfter = getMovieHelper().getAllMovies();

        assertThat(moviesAfter.size(), equalTo(moviesBefore.size()));
    }

}
