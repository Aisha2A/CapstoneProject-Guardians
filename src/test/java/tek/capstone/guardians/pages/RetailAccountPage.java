package tek.capstone.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "signinBtn")
	public WebElement signIn;

	@FindBy(linkText = "Account")
	public WebElement accountLink;

	@FindBy(id = "nameInput")
	public WebElement nameField;

	@FindBy(id = "personalPhoneInput")
	public WebElement phoneField;

	@FindBy(id = "personalUpdateBtn")
	public WebElement updateBttn;

	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateSuccessMssg;
	@FindBy(xpath = "//h1[@class='account__personal-title']")
	public WebElement yourProfile;

	@FindBy(id = "emailInput")
	public WebElement emailInputField;

	@FindBy(id = "previousPasswordInput")
	public WebElement previousPasswordInputField;

	@FindBy(id = "newPasswordInput")
	public WebElement newPasswordInputField;

	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPassInputField;

	@FindBy(id = "credentialsSubmitBtn")
	public WebElement changePasswordBtn;

	@FindBy(xpath = "//p[contains(text(),'payment')]")
	public WebElement addPaymentlink;

	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberField;

	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardField;

	@FindBy(id = "expirationMonthInput")
	public WebElement expMonthInput;

	@FindBy(id = "expirationYearInput")
	public WebElement expYearInput;

	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeInput;

	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBtn;

	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")

	public WebElement paymentAddedMsg;

//@FindBy(xpath="//button[text()='Edit']") public WebElement editCardBtn;

	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeCardBtn;

	@FindBy(xpath = "//button[@class='text-blue-800 cursor-pointer hover:underline' and text()='Edit']")

	public WebElement editPaymentCard;

	@FindBy(id = "paymentSubmitBtn")
	public WebElement updatePaymentBtn;

	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")

	public WebElement updatePaymentSuccessMsg;

	@FindBy(xpath = "//p[text()='Add Address']")
	public WebElement addAddressLink;

	@FindBy(id = "countryDropdown")
	public WebElement countryDropdown;

	@FindBy(id = "fullNameInput")
	public WebElement fullNameInput;

	@FindBy(id = "phoneNumberInput")
	public WebElement phoneNumberInput;

	@FindBy(id = "streetInput")
	public WebElement streetInput;

	@FindBy(id = "apartmentInput")
	public WebElement apartmentInput;

	@FindBy(id = "cityInput")
	public WebElement cityInput;

	@FindBy(xpath="//select[@name='state']")
	public WebElement stateField;

	@FindBy(id = "zipCodeInput")
	public WebElement zipCodeInput;

	@FindBy(id = "addressBtn")
	public WebElement addressBtn;

	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")

	public WebElement personalInfoUpdateMsg;
	@FindBy(xpath = "//div[@class='false account__payment-item']")
	public WebElement firstPaymentCard;

	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeCard;

	@FindBy(xpath = "//h1[@class='account__payment-new-title']")
	public WebElement addCardBoxHeader;

	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement AddingAddressMSG;
	@FindBy(xpath = "//button[@class='account__address-btn' and text()='Edit'][1]")

	public WebElement editAddressLink;

	@FindBy(id = "addressBtn")
	public WebElement updateAddressBtn;

	@FindBy(xpath = "//div[text()='Address Updated Successfully']")

	public WebElement addressUpdateSuccessMsg;

	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeAddressBttn;
	@FindBy(xpath = "//div[@class='account__address-single']")
	public WebElement addressBox;

}
