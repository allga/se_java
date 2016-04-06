package org.allga.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

    private WebDriver driver;

    public LoginPage loginPage;
    public InternalPage internalPage;
    public UserProfilePage userProfilePage;
    public UserManagementPage userManagementPage;
    public HomePage homePage;
    public AddPage addPage;
    public MoviePage moviePage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        loginPage = initElements(new LoginPage(this));
        internalPage = initElements(new InternalPage(this));
        userProfilePage = initElements(new UserProfilePage(this));
        userManagementPage = initElements(new UserManagementPage(this));
        homePage = initElements(new HomePage(this));
        addPage = initElements(new AddPage(this));
        moviePage = initElements(new MoviePage(this));
    }

    private <T extends Page> T initElements(T page) {
        //PageFactory.initElements(driver, page);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
        PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
        return page;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

}
