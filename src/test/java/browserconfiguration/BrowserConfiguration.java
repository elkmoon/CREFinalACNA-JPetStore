package browserconfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfiguration {

	public WebDriver driver;

	public WebDriver startBrowser(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			// Configuring the path for ChromeDriver (Windows)

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			// Configuring the path for GeckoDriver (Windows)

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		// Although Edge browser runs in Eclipse, there is a problem while running it in
		// Jenkins (pipeline).
		// Since it was only required to run the tests in two browsers we decided to not
		// run them in Edge browser.
		// we kept the driver here because if we add it to the Scenarios we can run
		// them, for instance, in IDE
		// without the pipeline and it runs also with edge browser.
		// case "edge":
		// Configuring the path for EdgeDriver (Windows)

		// WebDriverManager.edgedriver().setup();

		// driver = new EdgeDriver();
		// break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		return driver;
	}

	public void closeBrowser() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}