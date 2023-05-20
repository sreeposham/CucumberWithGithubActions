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
import qa.pages.DashboardPage;
import qa.pages.LoginsPage;
import qa.pages.StorePage;
import qa.pages.TransactionHistoryPage;
import qa.utils.ConfigLoader;

public class DashboardStepDefinitions {
	private final TestContext context;
	private final DashboardPage dashboardPage;
	private final TransactionHistoryPage transactionHistoryPage;

	public DashboardStepDefinitions(TestContext context) {
		this.context = context;
		dashboardPage = PageFactoryManager.getDashboardPage(context.driver);
		transactionHistoryPage = PageFactoryManager.getTransactionHistoryPage(context.driver);
	}

	@Then("I verify Dashboard page is displayed")
	public void i_verify_dashboard_page_is_displayed() {
		dashboardPage.verifyDashboardIsDisplayed();
	}

	@When("I click {string} button on Dashboard page")
	public void i_click_on_on_dashboard_page(String btn) {
		dashboardPage.clickButtonDashboardPage(btn);
	}
	
	@Then("I navigate to Transactions page")
	public void i_navigate_to_transactions_page() throws InterruptedException {
		dashboardPage.clickButtonDashboardPage("Transactions");
		transactionHistoryPage.verifyTransactionsPageDisplayed();
	}

	@Then("I verify {string} page is displayed")
	public void i_verify_page_is_displayed(String string) throws InterruptedException {
		dashboardPage.verifyPageNavigation(string);

	}
}
