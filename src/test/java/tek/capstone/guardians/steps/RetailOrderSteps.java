package tek.capstone.guardians.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String string) {
		click(factory.orderPage().allDepatmentOPtions);
		// Select select = new Select(factory.orderPage().allDepatmentOPtions);
		selectByVisibleText(factory.orderPage().allDepatmentOPtions, "Smart Home");
		logger.info("The category is changed to Smart Home");
	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String string) {
		sendText(factory.orderPage().searchInput, "kasa outdoor smart plug");
		logger.info("user search for kasa outdoor smart blug");

	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.orderPage().searchIcon);
		logger.info("search icon clicked");
	}

	@When("User click on item")
	public void userClickOnItem() {
		click(factory.orderPage().kasa);
		logger.info("item clicked successfully");
	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String string) {
		click(factory.orderPage().quantityOP);
		selectByValue(factory.orderPage().quantityOP, "2");
		logger.info("quantity selected");
	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.orderPage().addToCartBtn);
		logger.info("add to cart button clicked successfully");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String string) {
		if (factory.orderPage().quantityOP.equals("2")) {
			logger.info("qyantity changed to 2");
		}

	}

	// Addind address with order
	@When("User change the category to the {string}")
	public void userChangeTheCategoryToThe(String string) {
		click(factory.orderPage().allDepatmentOPtions);
		// Select select = new Select(factory.orderPage().allDepatmentOPtions);
		selectByVisibleText(factory.orderPage().allDepatmentOPtions, "Electronics");
		logger.info("user changed the category");
	}

	@When("User search for the item {string}")
	public void userSearchForTheItem(String string) {
		sendText(factory.orderPage().searchInput, "Apex Legends");
		logger.info("user search for Apex Legends");
	}

	@When("User clicks on Search icon")
	public void userClicksOnSearchIcon() {
		click(factory.orderPage().searchIcon);
		logger.info("search icon clicked");
	}

	@When("User clicks on item")
	public void userClicksOnItem() {
		click(factory.orderPage().apexItem);
		logger.info("item clicked successfully");
	}

	@When("User selects quantity {string}")
	public void userSelectsQuantity(String string) {
		click(factory.orderPage().quantityOP);
		selectByValue(factory.orderPage().quantityOP, "5");
		logger.info("quantity selected");
	}

	@When("User clicks add to Cart button")
	public void userClicksAddToCartButton() {
		click(factory.orderPage().addToCartBtn);
		logger.info("add to cart button clicked successfully");
	}

	@Then("the cart icon quantity should changed to {string}")
	public void theCartIconQuantityShouldChangedTo(String string) {
		if (factory.orderPage().quantityOP.equals("5")) {
			logger.info("qyantity changed to 5");
		}
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.orderPage().cartBtn);
		logger.info("cart button clicked");
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.orderPage().proceedCheckoutBtn);
		logger.info("checkout button clicked");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.orderPage().placeOrderBtn);
		logger.info(" Place order button clicked successfully");
	}

	@Then("a confirmation message should be displayed {string}")
	public void aConfirmationMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.orderPage().orderPlacedSuccessMsg);
		Assert.assertTrue(factory.orderPage().orderPlacedSuccessMsg.isDisplayed());
		logger.info("confirmation message displayed");
	}

	// cancel order
	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.orderPage().orderLink);
		logger.info("order section clicked");
	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
//		click(factory.orderPage().ItemsShowDetails);
//		logger.info("First order clicked")
		List<WebElement> listOfOrders = factory.orderPage().listOfOrders;
		for (int i = 0; i < listOfOrders.size(); i++) {
			if (listOfOrders.get(i).getText().equalsIgnoreCase("Hide Details")) {
			} else if (listOfOrders.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(factory.orderPage().listOfOrders.get(i));
			}
		}
		logger.info("first order in list clicked");
	}
	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.orderPage().cancelTheOrderBttn);
		logger.info("cancel order button clicked");
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String string) {
		click(factory.orderPage().cancellationReason);
		selectByIndex(factory.orderPage().cancellationReason, 1);
		logger.info("cancelation reason been selected");
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.orderPage().orderCancelBtn);
		logger.info("cancel order button clicked");
	}
	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String cancellationMsg) {
		waitTillPresence(factory.orderPage().orderCancellationMsg);

        Assert.assertEquals(cancellationMsg, factory.orderPage().orderCancellationMsg.getText());

        logger.info("cancelation message displayed");
	}
	// return order
	@When("User clicks on Orders section")
	public void userClicksOnOrdersSection() {
		click(factory.orderPage().orderLink);
		logger.info("order section clicked");
	}

	@When("User clicks on first order in list")
	public void userClicksOnFirstOrderInList() {
		click(factory.orderPage().ItemsShowDetails);
		logger.info("First order clicked");
	}

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.orderPage().orderReturnBtn);
		logger.info("return button clicked");
	}

	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String string) {
		click(factory.orderPage().cancellationReason);
		selectByIndex(factory.orderPage().cancellationReason, 2);
		logger.info("reaturn reason selected");
	}

	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String string) {
		click(factory.orderPage().dropOffService);
		selectByIndex(factory.orderPage().dropOffService, 2);
		logger.info("drop off service selected");
	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.orderPage().orderReturnAndSubmitBtn);
		logger.info("return order button clicked");
	}

	@Then("the cancelation message should be displayed 'Return was successful'​")
	public void theCancelationMessageShouldBeDisplayedReturnWasSuccessful​() {
		Assert.assertTrue(factory.orderPage().orderReturnSuccessMsg.isDisplayed());
		logger.info("return was successful");
	}

	// review order
	@When("User click on Orders sections")
	public void userClickOnOrdersSections() {
		click(factory.orderPage().orderLink);
		logger.info("order section clicked");
	}

	@When("User click on first order in the list")
	public void userClickOnFirstOrderInTheList() {
		click(factory.orderPage().ItemsShowDetails);
		logger.info("First order clicked");
	}

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.orderPage().reviewBtn);
		logger.info("review button clicked");
	}

	@When("User write Review headline ' headline value' and 'review text'")
	public void userWriteReviewHeadlineHeadlineValueAndReviewText() {
		sendText(factory.orderPage().headlineInputField, "Good Quality");
		sendText(factory.orderPage().commentField, "same as picture");
		logger.info("user write review");
	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.orderPage().addReviewBtn);
		logger.info("add review button clicked");
	}

	@Then("a review message should be displayed ‘Your review was added successfully’​")
	public void aReviewMessageShouldBeDisplayedYourReviewWasAddedSuccessfully​() {
		waitTillPresence(factory.orderPage().reviewAddedSuccessMsg);
		Assert.assertTrue(factory.orderPage().reviewAddedSuccessMsg.isDisplayed());
		logger.info("review message diplayed");
	}
}
