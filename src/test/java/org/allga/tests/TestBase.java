package org.allga.tests;

import java.util.concurrent.TimeUnit;

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
public class TestBase extends MovieHelper {

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
		click(By.name("submit"));
	}

}
