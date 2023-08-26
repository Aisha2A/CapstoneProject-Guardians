package tek.capstone.guardians.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailOrderPage extends BaseSetup {
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

//first scenario locators
	@FindBy(xpath = "//select[@id='search']")
	public WebElement allDepatmentOPtions;

	@FindBy(xpath = "//input[@id='searchInput']")
	public WebElement searchInput;

	@FindBy(xpath = "//button[@id='searchBtn']")
	public WebElement searchIcon;

	@FindBy(xpath = "//p[contains(text(),'Kasa Outdoor Smart Plug')]")
	public WebElement kasa;

	@FindBy(xpath = "//select[@class='product__select']")
	public WebElement quantityOP;

	@FindBy(xpath = "//button[@id='addToCartBtn']")
	public WebElement addToCartBtn;

//second scenario 
	@FindBy(xpath = "//p[@class='products__name']")
	public WebElement apexItem;

	@FindBy(id = "cartBtn")
	public WebElement cartBtn;

	@FindBy(id = "proceedBtn")
	public WebElement proceedCheckoutBtn;

	@FindBy(xpath = "//p[@class='order__header-btn' and text()='Show Details']")

	public WebElement ItemsShowDetails;//

	@FindBy(xpath = " //button[@id='placeOrderBtn']")
	public WebElement placeOrderBtn;

	@FindBy(xpath = "//div[@class='shadow md:w-3/4 bg-white p-4']")

	public WebElement orderConfirmationNumber;

	@FindBy(xpath="//button[@id='orderSubmitBtn']")
	public WebElement orderCancelBtn;

	@FindBy(id = "returnBtn")
	public WebElement orderReturnBtn;

	@FindBy(id = "buyAgainBtn")
	public WebElement orderBuyAgainBtn;

	@FindBy(xpath = "//div[text()='Order Placed Successfully']")

	public WebElement orderPlacedSuccessMsg;

	@FindBy(xpath = "//div[@class='order']")
	public WebElement firstOrderPlaced;

	@FindBy(xpath = "//select[@id='reasonInput']")
	public WebElement cancellationReason;

	@FindBy(xpath = "//select[@id='reasonInput']//option[@value='damage']")
	public WebElement itemDamageOption;

	@FindBy(xpath = "//div[@class='cancel__confirm-message']")
	public WebElement orderCancellationMsg;

	@FindBy(xpath = "//select[@id='dropOffInput']")
	public WebElement dropOffService;

	@FindBy(xpath = "//select[@id='dropOffInput']//option[text()='FedEx']")
	public WebElement fedExDropoffOption;

	@FindBy(xpath = "//button[@id='orderSubmitBtn']")
	public WebElement orderReturnAndSubmitBtn;

	@FindBy(xpath = "//p[text()='Return was successfull']")
	public WebElement orderReturnSuccessMsg;

	@FindBy(xpath = "//button[@id='cancelBtn']")
	public WebElement cancelTheOrderBttn;
// review scenario
	@FindBy(xpath = "//a[@id='orderLink']")
	public WebElement orderLink;//

	@FindBy(xpath = "//button[@id='reviewBtn']")
	public WebElement reviewBtn;//

	@FindBy(xpath = "//input[@id='headlineInput']")
	public WebElement headlineInputField;//

	@FindBy(xpath = "//textarea[@name='comment']")
	public WebElement commentField;//

	@FindBy(xpath = "//button[@id='reviewSubmitBtn']")
	public WebElement addReviewBtn;//

	@FindBy(xpath = "//div[text()='Your review was added successfully']")
	public WebElement reviewAddedSuccessMsg;//
// delete order
	@FindBy(xpath = "//span[@class='cart__item-delete']")
	public WebElement deleteOrderList;
	@FindBy(xpath = "//div[@class='order']//descendant::p[7]")

	public List<WebElement> listOfOrders;
}
