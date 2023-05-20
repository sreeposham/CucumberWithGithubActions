package qa.stepdefinitions;

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
import qa.pages.StorePage;

public class CustomersStepDefinitions {
	private final TestContext context;
	private final CustomersPage customersPage;

	public CustomersStepDefinitions(TestContext context) {
		this.context = context;
		customersPage = PageFactoryManager.getCustomersPage(context.driver);
	}

	@When("I navigated to the {string} page")
	public void i_navigated_to_the_page(String menu) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		customersPage.clickLeftMenuItem(menu);
	}

	@When("I search customer by {string} and {string} in the Customers page")
	public void i_search_customer_by_in_the_customers_page(String phoneCountry, String phone) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		customersPage.enterPhoneNumber(phoneCountry,phone);
		customersPage.clickSearch();
	}

	@Then("I verify customer registered with {string} in the Customers page")
	public void i_verify_customer_registered_with_in_the_customers_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}

	@When("I view the customer overview page of customer registered with {string}")
	public void i_view_the_customer_overview_page_of_customer_registered_with(String phone) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		customersPage.clickCustomerRecord(phone);
		customersPage.verifyLaunchCustomerOverview();
		Thread.sleep(5000);
	}




}
