package org.allga.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Olga on 05.04.2016.
 */
public class AddPage extends InternalPage {

    public AddPage(PageManager pages) {
        super(pages);
    }

    @FindBy(name = "name")
    private WebElement title;

    @FindBy(name = "year")
    private WebElement year;

    @FindBy(name = "submit")
    private WebElement submit;

    @FindBy(css = "input.error")
    private WebElement requiredFild;

    public WebElement getRequiredFild() {
        return requiredFild;
    }

    public void setTitle(String text) {
        title.clear();
        title.sendKeys(text);
    }

    public void setYear(String text) {
        year.clear();
        year.sendKeys(text);
    }

    public void clickSubmit() {
        submit.click();
        super.ensurePageLoaded();
    }

    public AddPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("imdbsearchform")));
        return this;
    }


}
