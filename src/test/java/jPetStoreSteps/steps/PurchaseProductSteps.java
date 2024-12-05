package jPetStoreSteps.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.PurchaseProduct;
import testcontext.TestContext;

public class PurchaseProductSteps {

	TestContext testContext;
	WebDriver driver;
	PurchaseProduct PurchaseProduct;

	public PurchaseProductSteps(TestContext context) {

		this.testContext = context; // Reuse context method
		this.driver = testContext.getDriver(); // Reuse driver
		PurchaseProduct = new pageobjects.PurchaseProduct(driver);

	}

	@And("I am autenticated with {string} and {string}")
	public void i_am_autenticated_with_and(String username, String password) {
		PurchaseProduct.accountLogin(username, password);
	}

	@And("I add a product to the cart using {string}")
	public void i_add_a_product_to_the_cart_using(String searchTerm) {
		PurchaseProduct.searchAndAddToCart(searchTerm);
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		PurchaseProduct.productCheckOut();
	}

	@And("I fill out my payment details")
	public void i_fill_out_my_payment_details() {
		PurchaseProduct.paymentDetails();
	}

	@And("I click the Continue button")
	public void i_click_the_continue_button() {
		PurchaseProduct.continueOrder();
	}

	@And("I confirm the order")
	public void i_confirm_the_order() {
		PurchaseProduct.confirmOrder();
	}

	@Then("I should see a confirmation message")
	public void i_should_see_a_confirmation_message() {
		PurchaseProduct.orderConfirmed();
	}

}
