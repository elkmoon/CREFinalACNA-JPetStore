package jPetStoreSteps.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testcontext.TestContext;

public class RegistrationSteps {

	TestContext testContext;
	WebDriver driver;
	pageobjects.Registration Registration;

	public RegistrationSteps(TestContext context) {
		this.testContext = context; // Reuse context method
		this.driver = testContext.getDriver(); // Reuse driver
		Registration = new pageobjects.Registration(driver);
	}

	@And("I navigate to the Create an account page")
	public void i_navigate_to_the_Create_an_account_page() {
		Registration.clickSignInToCreateAccountPage();
		Registration.clickRegisterNowToRegister();

	}

	@When("I fill in account registration with valid values")
	public void i_fill_in_account_registration_with_valid_values() {
		Registration.fillInAccountRegistrationWithRandomValues();
	}

	@And("I click the Create an Account button")
	public void i_click_the_create_an_account_button() {
		Registration.clickCreateAccountButton();
	}

	@Then("I should see be redirected to the main page")
	public void i_should_see_be_redirected_to_the_main_page() {
		Registration.AccountValidation();
	}

}
