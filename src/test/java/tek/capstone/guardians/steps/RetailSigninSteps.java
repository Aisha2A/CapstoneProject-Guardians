package tek.capstone.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;
import tek.capstone.guardians.utilities.DataGenerator;

public class RetailSigninSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		Assert.assertTrue(factory.homePage().tekschoolLogo.isDisplayed());

		logger.info("TEKSCHOOL logo is displayed");
	}

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.homePage().signInBtn);
		logger.info("signin button clicked");
	}

	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.signinPage().emailField, email);
		sendText(factory.signinPage().passwordField, password);
		logger.info("email and password entered successfully");
	}

	@And("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.signinPage().loginBtn);
		logger.info("login button clicked");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(factory.accountPage().accountLink.isDisplayed());
		logger.info("User is logged in");
	}

	// creating account
	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signinPage().newAccountBtn);
		logger.info("Creating new account button clicked");
	}

	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> accountInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.signinPage().nameInput, accountInfo.get(0).get("name"));
		sendText(factory.signinPage().emailInput, DataGenerator.emailGenerator());
		sendText(factory.signinPage().passwordInput, accountInfo.get(0).get("password"));
		sendText(factory.signinPage().confirmPasswordInput, accountInfo.get(0).get("confirmPassword"));
		logger.info("Signup Information entered successfully");

	}

	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.signinPage().signupBtn);
		logger.info("Signup button clicked successfully");
	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(factory.accountPage().accountLink.isDisplayed());
		logger.info("Account page is displayed");
	}

}