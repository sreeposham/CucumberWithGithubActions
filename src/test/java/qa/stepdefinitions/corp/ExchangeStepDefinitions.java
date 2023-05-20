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

public class ExchangeStepDefinitions {
	private final TestContext context;
	private final LoginsPage loginsPage;

	public ExchangeStepDefinitions(TestContext context) {
		this.context = context;
		loginsPage = PageFactoryManager.getLoginsPage(context.driver);
	}

	@When("I enter buying {string} and {string} on Exchange page")
	public void i_enter_buying_and_on_exchange_page(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click {string} button on Exchange page")
	public void i_click_button_on_exchange_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I verify Exchange details on Exchange review page")
	public void i_verify_exchange_details_on_exchange_review_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
