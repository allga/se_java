package org.allga.helpers;

import org.allga.util.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Olga on 05.04.2016.
 */
public class ApplicationManager {

    private WebDriver driver;
    protected String gridHubUrl;
    public String baseUrl;

    private MovieHelper movieHelper;
    private BaseHelper baseHelper;
    private NavigationHelper navigationHelper;

    public WebDriver getDriver() {
        return driver;
    }

    public void setUp() {
        baseUrl = PropertyLoader.loadProperty("site.url");
        gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(PropertyLoader.loadProperty("browser.name"));
        capabilities.setVersion(PropertyLoader.loadProperty("browser.version"));
        String platform = PropertyLoader.loadProperty("browser.platform");
        if (!(null == platform || "".equals(platform))) {
            capabilities.setPlatform(Platform.valueOf(PropertyLoader.loadProperty("browser.platform")));
        }

        if (!(null == gridHubUrl || "".equals(gridHubUrl))) {
            driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
        } else {
            driver = WebDriverFactory.getDriver(capabilities);
        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        movieHelper = new MovieHelper(this);
        baseHelper = new BaseHelper(driver);
        navigationHelper = new NavigationHelper(this);
        login("admin", "admin");
    }

    public void Stop() {
        if (driver != null) {
            WebDriverFactory.dismissDriver(driver);
        }
    }

    protected void login(String username, String password) {
        driver.get(baseUrl + "php4dvd/");
        getBaseHelper().pages.loginPage.ensurePageLoaded().
                setUsernameField(username).
                setPasswordField(password).
                clickSubmitButton();
    }

    public MovieHelper getMovieHelper() {
        return movieHelper;
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
