package org.allga.helpers;

import org.allga.model.MovieData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieHelper {

    protected WebDriver driver;
    private boolean acceptNextAlert = true;

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    protected void fillMovieForm(MovieData movie) {
        type(By.name("imdbid"), movie.getNumber());
        type(By.name("name"), movie.getTitle());
        type(By.name("year"), movie.getYear());
        type(By.name("duration"), movie.getDuration());
    }
}
