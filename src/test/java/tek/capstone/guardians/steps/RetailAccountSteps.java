package tek.capstone.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;
import tek.capstone.guardians.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

// update profile
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.accountPage().accountLink);
		logger.info("Account link clicked");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phone) {
		clearTextUsingSendKeys(factory.accountPage().nameField);
		sendText(factory.accountPage().nameField, name);
		clearTextUsingSendKeys(factory.accountPage().phoneField);
		sendText(factory.accountPage().phoneField, DataGenerator.getPhoneNumber());
		logger.info("user name and phone number are updated successfully");
	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().updateBttn);
		logger.info("Update button clicked successfully");

	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdateSuccessMssg);
		Assert.assertTrue(factory.accountPage().personalInfoUpdateSuccessMssg.isDisplayed());
		logger.info("profile information updated successfully");
	}

	// payment method
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addPaymentlink);
		logger.info("Add payment link is clicked");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < cardInfo.size(); i++) {
			sendText(factory.accountPage().cardNumberField, DataGenerator.getCardNumber());
			sendText(factory.accountPage().nameOnCardField, cardInfo.get(0).get("nameOnCard"));
			sendText(factory.accountPage().expMonthInput, cardInfo.get(0).get("expirationMonth"));
			sendText(factory.accountPage().expYearInput, cardInfo.get(0).get("expirationYear"));
			sendText(factory.accountPage().securityCodeInput, cardInfo.get(0).get("securityCode"));
		}
		logger.info("Card information entered");
	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().paymentSubmitBtn);
		logger.info("Add Card button is clicked");

	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String msg) {
		waitTillPresence(factory.accountPage().paymentAddedMsg);
		Assert.assertTrue(factory.accountPage().paymentAddedMsg.isDisplayed());
		msg = factory.accountPage().paymentAddedMsg.getText();
		logger.info("message is displayed: " + msg);

	}

// editing payment card
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().firstPaymentCard);
		click(factory.accountPage().editPaymentCard);
		logger.info("Edit option clicked");
	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> updateInfo = dataTable.asMaps(String.class, String.class);
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < cardInfo.size(); i++) {
			clearTextUsingSendKeys(factory.accountPage().cardNumberField);
			sendText(factory.accountPage().cardNumberField, DataGenerator.getCardNumber());
			clearTextUsingSendKeys(factory.accountPage().nameOnCardField);
			sendText(factory.accountPage().nameOnCardField, cardInfo.get(0).get("nameOnCard"));

			sendText(factory.accountPage().expMonthInput, cardInfo.get(0).get("expirationMonth"));

			sendText(factory.accountPage().expYearInput, cardInfo.get(0).get("expirationYear"));
			clearTextUsingSendKeys(factory.accountPage().securityCodeInput);
			sendText(factory.accountPage().securityCodeInput, cardInfo.get(0).get("securityCode"));
			logger.info("Information has been edited");
		}
	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().updatePaymentBtn);
		logger.info("Update button has been clicked");
	}

	@Then("update message should be displayed {string}")
	public void updateMessageShouldBeDisplayed(String actualmssg) {
		actualmssg = factory.accountPage().updatePaymentSuccessMsg.getText();
		String expectedMsg = "Payment Method updated Successfully";
		waitTillPresence(factory.accountPage().updatePaymentSuccessMsg);
		if (actualmssg == expectedMsg) {

			Assert.assertTrue(factory.accountPage().updatePaymentSuccessMsg.isDisplayed());

			logger.info("message is displayed: " + actualmssg);
		}
	}

	// remove card
	@And("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().firstPaymentCard);
		click(factory.accountPage().removeCard);
		logger.info("remove button clicked successfully");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(factory.accountPage().addCardBoxHeader.isDisplayed());
		logger.info("payment details removed");
	}

	// adding address
	@And("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressLink);
		logger.info("Add address link clicked");
	}

	@And("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < addressInfo.size(); i++) {
			sendText(factory.accountPage().countryDropdown, addressInfo.get(0).get("country"));
			sendText(factory.accountPage().fullNameInput, addressInfo.get(0).get("fullName"));
			sendText(factory.accountPage().phoneNumberInput, DataGenerator.getPhoneNumber());
			sendText(factory.accountPage().streetInput, addressInfo.get(0).get("streetAddress"));
			sendText(factory.accountPage().apartmentInput, addressInfo.get(0).get("apt"));
			sendText(factory.accountPage().cityInput, addressInfo.get(0).get("city"));
			sendText(factory.accountPage().stateField, addressInfo.get(0).get("state"));
			sendText(factory.accountPage().zipCodeInput, DataGenerator.getZipCode());

		}
		logger.info("Address form filled");
	}

	@And("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.accountPage().addressBtn);
		logger.info("Add Address button clicked");
	}

	@Then("address message should be displayed 'Address Added Successfully'")
	public void addressMessageShouldBeDisplayedAddressAddedSuccessfully() {
		waitTillPresence(factory.accountPage().AddingAddressMSG);
		Assert.assertTrue(factory.accountPage().AddingAddressMSG.isDisplayed());
		logger.info("message for adding address displayed");
	}

	// editing address
	@And("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.accountPage().editAddressLink);
		logger.info("edit address link clicked");
	}

	@And("user fill new address form with below informationss")
	public void userFillNewAddressFormWithBelowInformationss(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < addressInfo.size(); i++) {
			sendText(factory.accountPage().countryDropdown, addressInfo.get(0).get("country"));
			clearTextUsingSendKeys(factory.accountPage().fullNameInput);
			sendText(factory.accountPage().fullNameInput, addressInfo.get(0).get("fullName"));
			clearTextUsingSendKeys(factory.accountPage().phoneNumberInput);
			sendText(factory.accountPage().phoneNumberInput, DataGenerator.getPhoneNumber());
			clearTextUsingSendKeys(factory.accountPage().streetInput);
			sendText(factory.accountPage().streetInput, addressInfo.get(0).get("streetAddress"));
			clearTextUsingSendKeys(factory.accountPage().apartmentInput);
			sendText(factory.accountPage().apartmentInput, addressInfo.get(0).get("apt"));
			clearTextUsingSendKeys(factory.accountPage().cityInput);
			sendText(factory.accountPage().cityInput, addressInfo.get(0).get("city"));
			sendText(factory.accountPage().stateField, addressInfo.get(0).get("state"));
			clearTextUsingSendKeys(factory.accountPage().zipCodeInput);
			sendText(factory.accountPage().zipCodeInput, DataGenerator.getZipCode());
		}
		logger.info("New address form filled");

	}

	@And("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().updateAddressBtn);
		logger.info("update address button clicked");
	}



	@And("update address message should be displayed 'Address Updated Successfully'")
	    public void updateAddressMessageShouldBeDisplayed() {
	        waitTillPresence(factory.accountPage().addressUpdateSuccessMsg);
	        Assert.assertTrue(factory.accountPage().addressUpdateSuccessMsg.isDisplayed());
	        logger.info("update address message displayed");
	    }

	// remove address
	@And("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		scrollPageDownWithJS();
		click(factory.accountPage().removeAddressBttn);
		logger.info("remove button clicked");

	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		if (!isElementDisplayed(factory.accountPage().addressBox)) {
			logger.info("address details removed");
		}
	}

}
