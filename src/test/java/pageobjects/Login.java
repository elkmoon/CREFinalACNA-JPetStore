package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.StepUtils;

import static org.junit.Assert.assertEquals;

public class Login {

	private final WebDriver driver;

	private WebElement userIdInputField;
	private WebElement userNameInputField;
	private WebElement passwordField;
	private WebElement logInButton;
	private WebElement logInVerification;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void signInButton() {
		userIdInputField = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
		userIdInputField.click();
	}

	public void userNameField(String username) {
		userNameInputField = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		userNameInputField.clear();
		userNameInputField.sendKeys(username);

		StepUtils.slowSendKeys(username, userNameInputField);
	}

	public void passwordField(String password) {
		passwordField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='password'])[1]")));
		passwordField.clear();
		passwordField.sendKeys(password);

		StepUtils.slowSendKeys(password, passwordField);
	}

	public void logInButtonClick() {
		logInButton = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));
		logInButton.click();

	}

	public void verifyLogIn() {
		logInVerification = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#WelcomeContent")));
		assertEquals(logInVerification.getText(), "Welcome Elkmoon!");

	}

}
