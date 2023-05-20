package qa.stepdefinitions.corp;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.context.TestContext;
import qa.domainobjects.BillingDetails;
import qa.enums.EndPoint;
import qa.factory.PageFactoryManager;
import qa.pages.CustomersPage;
import qa.pages.LoginsPage;
import qa.pages.StorePage;
import qa.utils.ConfigLoader;

public class LoginsStepDefinitions {
	private final TestContext context;
	private final LoginsPage loginsPage;
	String email = "sreekanth@hubpay.ae";
	String password = "Hubpass@1";

	public LoginsStepDefinitions(TestContext context) {
		this.context = context;
		loginsPage = PageFactoryManager.getLoginsPage(context.driver);
	}

	public void launchApplication(String app) {
		if (app.equals(null))
			return;
		switch (app.toUpperCase()) {
		case "CORP PORTAL":
			loginsPage.load(ConfigLoader.getInstance().getCorpUrl());
			break;
		case "OPS PORTAL":
			loginsPage.load(ConfigLoader.getInstance().getOpsUrl());
			break;
		default:
		}
	}

	@Given("I'm Logged in to the Admin portal")
	public void i_m_logged_in_to_the_admin_portal() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		launchApplication("Ops Portal");
		loginsPage.loginMicrosoft(email, password);
//		Thread.sleep(50000);
	}

	@Given("I landed on Corp portal Login Page")
	public void I_landed_on_CorpSuite_Login_Page() throws IOException {
		launchApplication("Corp Portal");
	}

	@When("I'm Logged in to the Corp portal")
	public void I_enter_credentials_on_CorpSuite_Login_Page() throws IOException {
		loginsPage.loginCorpPortal(email, password);
	}

}
