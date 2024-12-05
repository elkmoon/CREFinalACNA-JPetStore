package pageobjects;

import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductToCart {

	private final WebDriver driver;

	private WebElement productToAdd;
	private WebElement addToCartButton;
	private WebElement shoppingCart;

	public AddProductToCart(WebDriver driver) {
		this.driver = driver;
	}

	public void selectProduct(String searchTerm) {
		productToAdd = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Great stress reliever")));
		assertEquals(productToAdd.getText(), "Great stress reliever");
		productToAdd.click();

	}

	public void addProductToCart() {
		addToCartButton = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Add to Cart']")));
		addToCartButton.click();

		shoppingCart = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[normalize-space()='Shopping Cart']")));
		assertEquals(shoppingCart.getText(), "Shopping Cart");

	}

}
