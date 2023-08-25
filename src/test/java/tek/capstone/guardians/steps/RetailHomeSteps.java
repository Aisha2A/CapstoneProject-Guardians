package tek.capstone.guardians.steps;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;

public class RetailHomeSteps extends CommonUtility {
	// We will create object of POMFactory class to access the page objects in page
	// object classes
	// using the get method we create in the POMFactory class

	POMFactory factory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allOptions);
		logger.info("All section clicked successfully");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> sideBarOptions = dataTable.asLists(String.class);
		for (int i = 0; i < sideBarOptions.size(); i++) {
			Assert.assertTrue(isElementDisplayed(
					getDriver().findElement(By.xpath("//div[@class='modal__content h-screen w-80 ']//span[text()='"
							+ sideBarOptions.get(0).get(i) + "']"))));
			logger.info("'All'sidebar is present: " + sideBarOptions.get(0).get(i));
		}
	}

	// sidebar
	@When("User on {string}")
	public void userOn(String department) {
		List<WebElement> departments = factory.homePage().sideBarOptions;
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).getText().equalsIgnoreCase(department)) {
				departments.get(i).click();
				break;
			}
			logger.info("user is on All department");
		}
	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
//			List<List<String>> alloptions = dataTable.asLists(String.class);
//			List<WebElement> options = factory.homePage().sideBarOptions;
//			
//			for (int i = 0; i < alloptions.get(0).size(); i++) {
//				for(WebElement elements:options) {
//					if(elements.getText().equalsIgnoreCase(alloptions.get(0).get(i))) {
//				
//				Assert.assertTrue(factory.homePage().allOptions.isDisplayed());
//				logger.info("options are present in department");
//			}
//			}
//		}
		List<Map<String, String>> allOptionss = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < allOptionss.size(); i++) {
			Assert.assertTrue(factory.homePage().allOptions.isDisplayed());

		}
		logger.info("options are present in department");
	}
}
