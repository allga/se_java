package org.allga.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieDeletionTests extends TestBase {

    @Test
    public void testDeletionMovie()  {
        getNavigationHelper().goToHomePage();
        int before = getMovieHelper().countAllMovies();
        getMovieHelper().allMovies().get(0).click();
        getMovieHelper().deleteMovie();
        getNavigationHelper().goToHomePage();
        int after = getMovieHelper().countAllMovies();
        assertThat(after, equalTo(before - 1));
    }

}
