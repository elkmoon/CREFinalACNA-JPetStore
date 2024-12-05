package pageobjects;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.PurchaseProduct;

import randomcredentialsgenerator.RandomCredentialsGenerator;


public class PurchaseProduct {

	private final WebDriver driver;

	private Login Login;
	private SearchAndCheckProduct searchAndCheckProduct;
	private AddProductToCart addProductToCart;

	private WebElement proceedToCheckOut;
	private WebElement cardTypeField;
	private WebElement continueButton;
	private WebElement confirmButton;
	private WebElement orderConfirmation;

	public PurchaseProduct(WebDriver driver) {
		new RandomCredentialsGenerator();
		this.driver = driver;
		this.Login = new Login(driver); // Instantiate UserLogin
		this.addProductToCart = new AddProductToCart(driver); // Instantiate AddProductToCart
		this.searchAndCheckProduct = new SearchAndCheckProduct(driver);
	}

	public void accountLogin(String username, String password) {
		Login.signInButton();
		Login.userNameField(username);
		Login.passwordField(password);
		Login.logInButtonClick();
		Login.verifyLogIn();
	}

	public void searchAndAddToCart(String searchTerm) {
		searchAndCheckProduct.searchItem(searchTerm);
		searchAndCheckProduct.clickSearchButton();
		addProductToCart.selectProduct(searchTerm);
		addProductToCart.addProductToCart();
	}

	public void productCheckOut() {
		proceedToCheckOut = new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Proceed to Checkout']")));
		proceedToCheckOut.click();

	}

	public void paymentDetails() {
		cardTypeField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='order.cardType']")));
		cardTypeField.sendKeys("MasterCard");
		

	}

	public void continueOrder() {
		continueButton = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='newOrder']")));
		continueButton.click();

	}

	public void confirmOrder() {
		confirmButton = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Confirm']")));
		confirmButton.click();

	}

	public void orderConfirmed() {
		orderConfirmation = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul[class='messages'] li")));
		assertEquals(orderConfirmation.getText(), "Thank you, your order has been submitted.");

	}

}
