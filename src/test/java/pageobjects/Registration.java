package pageobjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import randomcredentialsgenerator.RandomCredentialsGenerator;
import utils.StepUtils;

public class Registration {

	private final WebDriver driver;

	private String randomUserId;
	private String randomFirstName;
	private String randomLastName;
	private String randomPassword;
	private String randomEmail;
	private String randomPhone;
	private String randomAddress1;
	private String randomAddress2;
	private String randomCity;
	private String randomState;
	private String randomZipCode;
	private String randomCountry;

	private WebElement clickSignInToAccountLink;
	private WebElement clickToCreateAccountPage;
	private WebElement userIdInputField;
	private WebElement firstNameInputField;
	private WebElement lastNameInputField;
	private WebElement emailInputField;
	private WebElement phoneInputField;
	private WebElement address1InputField;
	private WebElement address2InputField;
	private WebElement cityInputField;
	private WebElement stateInputField;
	private WebElement zipCodeInputField;
	private WebElement countryInputField;
	private WebElement passowrdInputField;
	private WebElement confirmPasswordInputField;
	private WebElement saveAccountButton;
	private WebElement favouriteCategory;

	public Registration(WebDriver driver) {

		randomUserId = RandomCredentialsGenerator.generateRandomUserId(6);
		randomFirstName = RandomCredentialsGenerator.generateRandomName(6);
		randomLastName = RandomCredentialsGenerator.generateRandomName(6);
		randomPassword = RandomCredentialsGenerator.generateRandomPassword(6);
		randomEmail = RandomCredentialsGenerator.generateRandomEmail();
		randomPhone = RandomCredentialsGenerator.generateRandomZipCode();
		randomAddress1 = RandomCredentialsGenerator.generateRandomName(6);
		randomAddress2 = RandomCredentialsGenerator.generateRandomName(6);
		randomCity = RandomCredentialsGenerator.generateRandomName(6);
		randomState = RandomCredentialsGenerator.generateRandomName(6);
		randomZipCode = RandomCredentialsGenerator.generateRandomZipCode();
		randomCountry = RandomCredentialsGenerator.generateRandomName(6);

		this.driver = driver;
	}

	public void clickSignInToCreateAccountPage() {
		clickSignInToAccountLink = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
		clickSignInToAccountLink.click();
	}

	public void clickRegisterNowToRegister() {
		clickToCreateAccountPage = new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Register Now!'])[1]")));
		clickToCreateAccountPage.click();
	}

	public void fillInAccountRegistrationWithRandomValues() {

		// userIdInputField.sendKeys(userId);
		userIdInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		userIdInputField.sendKeys(randomUserId);

		StepUtils.slowSendKeys(randomUserId, userIdInputField);

		// passowrdInputField.sendKeys(password);
		passowrdInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		passowrdInputField.sendKeys(randomPassword);

		// confirmPasswordInputField.sendKeys(password);
		confirmPasswordInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='repeatedPassword']")));
		confirmPasswordInputField.sendKeys(randomPassword);

		// passowrdInputField.sendKeys(randomPassword);

		StepUtils.slowSendKeys(randomPassword, confirmPasswordInputField);

		// firstNameInputField.sendKeys(firstName);
		firstNameInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='account.firstName']")));

		StepUtils.slowSendKeys(randomFirstName, firstNameInputField);

		// lastNameInputField.sendKeys(lastName);
		lastNameInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='account.lastName']")));

		StepUtils.slowSendKeys(randomLastName, lastNameInputField);

		// emailInputField.sendKeys(email);
		emailInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("account.email")));

		StepUtils.slowSendKeys(randomEmail, emailInputField);

		phoneInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='account.phone']")));
		phoneInputField.sendKeys(randomPhone);

		// address1InputField.sendKeys(phone);
		address1InputField = new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='account.address1'] ")));

		StepUtils.slowSendKeys(randomAddress1, address1InputField);

		// address2InputField.sendKeys(address2);
		address2InputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='account.address2']")));

		StepUtils.slowSendKeys(randomAddress2, address2InputField);

		// cityInputField.sendKeys(city);
		cityInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='account.city']")));

		StepUtils.slowSendKeys(randomCity, cityInputField);

		// StateInputField.sendKeys(state);
		stateInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='account.state']")));

		StepUtils.slowSendKeys(randomState, stateInputField);

		// zipCodeInputField.sendKeys(zipCode);
		zipCodeInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='account.zip']")));

		StepUtils.slowSendKeys(randomZipCode, zipCodeInputField);

		// CountryInputField.sendKeys(country);
		countryInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("account.country")));

		StepUtils.slowSendKeys(randomCountry, countryInputField);

		favouriteCategory = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("select[name='account.favouriteCategoryId']")));
		favouriteCategory.sendKeys("DOGS");

	}

	public void clickCreateAccountButton() {
		saveAccountButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.name("newAccount")));
		saveAccountButton.click();
	}

	public void AccountValidation() {

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://petstore.octoperf.com/actions/Catalog.action");
	}

}
