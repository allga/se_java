package org.allga.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Olga on 29.03.2016.
 */
public class HelperBase {

    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }



}
