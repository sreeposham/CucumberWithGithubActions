package qa.stepdefinitions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.context.TestContext;
import qa.factory.PageFactoryManager;
import qa.pages.CustomerOverviewPage;

public class CustomerOverviewStepDefinitions {
	private final TestContext context;
	private final CustomerOverviewPage customerOverviewPage;

	public CustomerOverviewStepDefinitions(TestContext context) {
		this.context = context;
		customerOverviewPage = PageFactoryManager.getCustomerOverviewPage(context.driver);
	}

	@When("I open Promote to business form for the customer")
	public void iOpenPromoteToBusinessForm() throws InterruptedException {
		customerOverviewPage.openPromoteToBusinessForm();
	}

	@When("I fill the business details on Promote to business form for the customer {string}")
	public void iFillBusinessForm(String businessdetails) throws InterruptedException {
		String[] businessdetailslist=businessdetails.split(",");
		HashMap<String, String> datamap = new HashMap<String, String>();
		for (String str : businessdetailslist) {
			datamap.put(str.split("=")[0], str.split("=")[1]);
		}
		customerOverviewPage.fillBusinessDetailsInForm(datamap);
	}

	@When("I submit the business details for the customer to Promote to business")
	public void iSubmitBusinessDetailsForCustomer() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		customerOverviewPage.clickSubmitBtn();
		customerOverviewPage.verifyAlertMessage("Account was promoted to business succesfully.");
	}
	@When("I update the {string} to {string} with note {string}")
	public void iUpdateStatusWithNote(String statusLabel,String status, String note) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		customerOverviewPage.editCustomerStatus(statusLabel,status,note);
	}
	@Then("I verify user is promoted to business successfully")
	public void iVerifyPromoteToBusinessSuccessful() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		customerOverviewPage.verifyBusinessUserStatusCheck();
	}
}
