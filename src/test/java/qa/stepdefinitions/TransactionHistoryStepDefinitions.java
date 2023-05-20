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

public class TransactionHistoryStepDefinitions {
	private final TestContext context;
	private final LoginsPage loginsPage;
	String email = "sreekanth@hubpay.ae";
	String password = "Hubpass@1";

	public TransactionHistoryStepDefinitions(TestContext context) {
		this.context = context;
		loginsPage = PageFactoryManager.getLoginsPage(context.driver);
	}

	@Then("I verify {string} record on Transactions page.")
	public void i_verify_record_on_transactions_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
