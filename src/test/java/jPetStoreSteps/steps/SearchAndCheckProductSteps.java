package jPetStoreSteps.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SearchAndCheckProduct;
import testcontext.TestContext;

public class SearchAndCheckProductSteps {

	TestContext testContext;
	WebDriver driver;
	SearchAndCheckProduct searchAndCheckProduct;

	public SearchAndCheckProductSteps(TestContext context) {
		this.testContext = context;
		this.driver = testContext.getDriver();
		// this.addProductToCart = new AddProductToCart(driver);
		this.searchAndCheckProduct = new SearchAndCheckProduct(driver);

	}

	@When("I enter {string} in the search bar")
	public void i_enter_in_the_search_bar(String searchTerm) {
		searchAndCheckProduct.searchItem(searchTerm);

	}

	@And("I click the Search button")
	public void i_click_the_search_button() {
		searchAndCheckProduct.clickSearchButton();

	}

	@Then("I should see a list of products related to {string}")
	public void i_should_see_a_list_of_products_related_to(String searchTerm) {
		searchAndCheckProduct.verifyIfProducFoundandClick();

	}

	@And("I searched for {string} and results are displayed")
	public void i_searched_for_and_results_are_displayed(String searchTerm) {
		searchAndCheckProduct.searchItem(searchTerm);
		searchAndCheckProduct.clickSearchButton();
		searchAndCheckProduct.verifyIfProducFoundandClick();

	}

	@When("I click on the first item")
	public void i_click_on_the_first_item() {
		searchAndCheckProduct.chooseProductFromList();
	}

	@Then("I should be redirected to the product details page")
	public void i_should_be_redirected_to_the_product_details_page() {
		searchAndCheckProduct.verifyProductDetails();

	}

}
