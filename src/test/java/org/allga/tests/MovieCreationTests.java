package org.allga.tests;

import org.allga.model.MovieData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieCreationTests extends TestBase {

    @Test
    public void testPositiveCreationMovie() {
        getHelperBase().click(By.cssSelector("a[href=\"./?go=add\"]"));
        MovieData movie = new MovieData().setNumber("0711111").setTitle("Miles Ahead").setYear("2015").setDuration("100");
        getMovieHelper().fillMovieForm(movie);
        getHelperBase().click(By.name("submit"));
        assertThat((driver.getCurrentUrl()), containsString("php4dvd/?go=movie&id="));
    }

    @Test
    public void testRequiredFieldCreationMovie() {
        getHelperBase().click(By.cssSelector("a[href=\"./?go=add\"]"));
        MovieData movie = new MovieData().setNumber("0711111").setYear("2015").setDuration("100");
        getMovieHelper().fillMovieForm(movie);
        getHelperBase().click(By.name("submit"));
        assertThat((driver.getCurrentUrl()), containsString("php4dvd/?go=add"));
    }

}
