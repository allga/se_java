package org.allga.tests;

import org.allga.helpers.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

/**
 * Base class for all the TestNG-based test classes
 */
public class TestBase {

	protected final ApplicationManager app = new ApplicationManager();

	@BeforeClass
	public void init() {
		app.setUp();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		app.Stop();
	}

}
