package jPetStoreSteps.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testcontext.TestContext;

public class LoginSteps {

	TestContext testContext;;
	WebDriver driver;
	pageobjects.Login Login;

	public LoginSteps(TestContext context) {
		this.testContext = context;
		this.driver = testContext.getDriver();
		Login = new pageobjects.Login(driver);
	}

	@And("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
		Login.signInButton();
	}

	@When("I enter my {string} and {string}")
	public void i_enter_my_username_and_password(String username, String password) {
		Login.userNameField(username);
		Login.passwordField(password);
	}

	@And("I click the Login button")
	public void i_click_the_login_button() {
		Login.logInButtonClick();
	}

	@Then("I should see a welcome message")
	public void i_should_see_a_welcome_message() {
		Login.verifyLogIn();
	}

}
