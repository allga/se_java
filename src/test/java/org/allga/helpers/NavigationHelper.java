package org.allga.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Olga on 29.03.2016.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper (WebDriver driver) {
        super(driver);
    }

    public void goToAddMoviePage() {
        click(By.cssSelector("a[href=\"./?go=add\"]"));
    }

    public void goToHomePage() {
        click(By.tagName("h1"));
    }

}
