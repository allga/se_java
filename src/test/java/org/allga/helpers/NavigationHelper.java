package org.allga.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Olga on 29.03.2016.
 */
public class NavigationHelper extends BaseHelper {

    public NavigationHelper(ApplicationManager manager) {
        super(manager.getDriver());
    }

    public void goToAddMoviePage() {
        pages.homePage.clickAddMovie().ensurePageLoaded();
    }

    public void goToHomePage() {
        pages.internalPage.clickHomeLink().ensurePageLoaded();
    }

}
