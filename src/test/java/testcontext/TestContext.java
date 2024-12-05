package testcontext;

import org.openqa.selenium.WebDriver;

/**
 * TestContext Class: It is used to store information provided for the tests. In
 * this Project it stores and incorporates the access and logic of the
 * WebDriver, allowing the reuse of the same WebDriver during tests and/or suite
 * of tests executions.
 * 
 * <p>
 * The purpose of this class is to simplify the use of the WebDriver, for
 * instance, in different steps of the Cucumber features. Project. Advantages: -
 * No need to define the WebDriver several times; - No need to create separated
 * instances of the WebDriver; - Resources saving; - Higher Test consistency; -
 * Reuse of code.
 */
public class TestContext {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
