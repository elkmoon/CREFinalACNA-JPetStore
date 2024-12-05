package jPetStoreSteps.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import testcontext.TestContext;

import org.openqa.selenium.WebDriver;

import browserconfiguration.BrowserConfiguration;

public class HomePageSteps {
	private final TestContext testContext;
	private BrowserConfiguration browserConfiguration;

	public HomePageSteps(TestContext testContext) {
		this.testContext = testContext;
		this.browserConfiguration = new BrowserConfiguration();
	}

	@Given("I am on the homepage using {string}")
	public void i_am_on_the_homepage_using(String browser) {
		WebDriver driver = this.browserConfiguration.startBrowser(browser);
		testContext.setDriver(driver);
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	}

	@After
	public void closeBrowser(Scenario scenario) {
		this.browserConfiguration.closeBrowser();
	}

}
