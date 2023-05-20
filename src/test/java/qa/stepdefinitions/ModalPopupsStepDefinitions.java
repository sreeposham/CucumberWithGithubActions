package qa.stepdefinitions;

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

public class ModalPopupsStepDefinitions {
	private final TestContext context;
	private final LoginsPage loginsPage;
	String email = "sreekanth@hubpay.ae";
	String password = "Hubpass@1";

	public ModalPopupsStepDefinitions(TestContext context) {
		this.context = context;
		loginsPage = PageFactoryManager.getLoginsPage(context.driver);
	}

	@Then("I verify Success modal is displayed")
	public void i_verify_success_modal_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I verify Exchange details on Success modal")
	public void i_verify_exchange_details_on_success_modal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click {string} on Success modal")
	public void i_click_on_success_modal(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
