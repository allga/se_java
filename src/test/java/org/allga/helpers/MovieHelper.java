package org.allga.helpers;

import org.allga.model.MovieData;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieHelper extends BaseHelper {

    public MovieHelper(ApplicationManager manager) {
        super(manager.getDriver());
    }

    public boolean isLoggedIn (){
        return pages.internalPage.waitPageLoaded();
    }

    public boolean isMovieSaved (){
        return pages.moviePage.waitPageLoaded();
    }


    public void createMovie(MovieData movie) {
        pages.addPage.setTitle(movie.getTitle());
        pages.addPage.setYear(movie.getYear());
        pages.addPage.clickSubmit();
    }

    public List<WebElement> allMovies() {
        return pages.homePage.ensurePageLoaded().getMovies();
    }

    public void openDeletedMovie(int index) {
        pages.homePage.ensurePageLoaded().openMovie(index).ensurePageLoaded();
    }

    public List<MovieData> getAllMovies() {
        List<MovieData> movies = new ArrayList<MovieData>();
        for (WebElement el : allMovies()) {
            String title = el.getText();
            movies.add(new MovieData().setTitle(title));
        }
        return movies;
    }

    public void deleteMovie() {
        pages.moviePage.clickRemoveButton().ensurePageLoaded();
    }

    public void searchMovies(String title) {
        pages.homePage.ensurePageLoaded().searchByTitle(title).ensurePageLoaded();
    }

    public String searchMotFound(String unrealTitle) {
        pages.homePage.ensurePageLoaded().searchByTitle(unrealTitle).ensurePageLoaded();
        return pages.homePage.getSearchNull();
    }

    public boolean isFieldRequired() {
        try {
            pages.addPage.getRequiredFild();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
