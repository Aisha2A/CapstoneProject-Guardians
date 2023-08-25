package tek.capstone.guardians.pages;

import tek.capstone.guardians.base.BaseSetup;

public class POMFactory extends BaseSetup {
	private RetailHomePage homePage;
	private RetailSignInPage signinPage;
	private RetailAccountPage accountPage;
	private RetailOrderPage orderPage;

	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signinPage = new RetailSignInPage();
		this.accountPage = new RetailAccountPage();
		this.orderPage = new RetailOrderPage();
	}

	public RetailHomePage homePage() {
		return this.homePage;
	}

	public RetailSignInPage signinPage() {
		return this.signinPage;
	}

	public RetailAccountPage accountPage() {
		return this.accountPage;
	}

	public RetailOrderPage orderPage() {
		return this.orderPage;
	}
}
