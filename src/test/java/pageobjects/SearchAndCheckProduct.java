package pageobjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.StepUtils;

public class SearchAndCheckProduct {

	private final WebDriver driver;
	private WebElement searchBarField;
	private WebElement searchButton;
	private WebElement productLink;
	private WebElement productList;
	private WebElement ProductNameConfirmation;
	private WebElement ProductIdConfirmation;
	private WebElement ProductPriceConfirmation;

	public SearchAndCheckProduct(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String searchTerm) {
		searchBarField = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='keyword']")));
		searchBarField.sendKeys(searchTerm);

		StepUtils.slowSendKeys(searchTerm, searchBarField);
	}

	public void clickSearchButton() {
		searchButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Search']")));
		searchButton.click();

	}

	public void verifyIfProducFoundandClick() {
		productLink = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Great stress reliever")));
		assertEquals(productLink.getText(), "Great stress reliever");
		productLink.click();

	}

	public void chooseProductFromList() {
		productList = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='EST-19']")));
		assertEquals(productList.getText(), "EST-19");
		productList.click();

	}

	public void verifyProductDetails() {

		ProductNameConfirmation = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//font[contains(text(),'Adult Male')])[1]")));
		String confirmationTextName = ProductNameConfirmation.getText();
		Assert.assertEquals("Adult Male Finch", confirmationTextName);

		ProductIdConfirmation = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//b[normalize-space()='EST-19'])[1]")));
		String confirmationTextId = ProductIdConfirmation.getText();
		Assert.assertEquals("EST-19", confirmationTextId);

		ProductPriceConfirmation = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='$15.50']")));
		String confirmationTextPrice = ProductPriceConfirmation.getText();
		Assert.assertEquals("$15.50", confirmationTextPrice);

	}

}