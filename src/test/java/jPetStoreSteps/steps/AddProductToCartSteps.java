package jPetStoreSteps.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.AddProductToCart;
import pageobjects.SearchAndCheckProduct;
import testcontext.TestContext;

public class AddProductToCartSteps {

	TestContext testContext;;
	WebDriver driver;
	AddProductToCart addProductToCart;
	SearchAndCheckProduct searchAndCheckProduct;

	public AddProductToCartSteps(TestContext context) {
		this.testContext = context;
		this.driver = testContext.getDriver();
		this.addProductToCart = new AddProductToCart(driver);
		this.searchAndCheckProduct = new SearchAndCheckProduct(driver);

	}

	@And("I click on the item after searching {string}")
	public void i_click_on_the_item_after_searching(String searchTerm) {
		searchAndCheckProduct.clickSearchButton();
		addProductToCart.selectProduct(searchTerm);
	}

	@Then("I click on the Add to cart button")
	public void i_click_on_the_add_to_cart_button() {
		addProductToCart.addProductToCart();
	}

}
