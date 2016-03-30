package org.allga.tests;

import java.util.concurrent.TimeUnit;

import org.allga.helpers.HelperBase;
import org.allga.helpers.MovieHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import ru.stqa.selenium.factory.WebDriverFactory;

import org.allga.util.PropertyLoader;

/**
 * Base class for all the TestNG-based test classes
 */
public class TestBase {

    protected WebDriver driver;

	private MovieHelper movieHelper;
	private HelperBase helperBase;
    private NavigationHelper navigationHelper;

	protected String gridHubUrl;

	protected String baseUrl;

	@BeforeClass
	public void init() {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		movieHelper = new MovieHelper(driver);
		helperBase = new HelperBase(driver);
        navigationHelper = new NavigationHelper(driver);
		login("admin", "admin");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			WebDriverFactory.dismissDriver(driver);
		}
	}

	protected void login(String username, String password) {
        driver.get(baseUrl + "php4dvd/");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
		getHelperBase().click(By.name("submit"));
	}

	public MovieHelper getMovieHelper() {
		return movieHelper;
	}

	public HelperBase getHelperBase() {
		return helperBase;
	}

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
