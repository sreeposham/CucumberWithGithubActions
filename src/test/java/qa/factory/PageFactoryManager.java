/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework (https://www.udemy.com/course/cucumber-bdd-masterclass/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package qa.factory;

import org.openqa.selenium.WebDriver;

import qa.pages.CartPage;
import qa.pages.CheckoutPage;
import qa.pages.CustomerOverviewPage;
import qa.pages.CustomersPage;
import qa.pages.DashboardPage;
import qa.pages.ExchangePage;
import qa.pages.LoginsPage;
import qa.pages.ModalPopupsPage;
import qa.pages.ProductPage;
import qa.pages.StorePage;
import qa.pages.TransactionHistoryPage;

public class PageFactoryManager {

    private static CartPage cartPage;
	private static StorePage storePage;
    private static CustomersPage customersPage;
    private static CustomerOverviewPage customerOverviewPage;
    private static CheckoutPage checkoutPage;
    private static ProductPage productPage;
    private static LoginsPage loginsPage;
    private static DashboardPage dashboardPage;
    private static ExchangePage exchangePage;
    private static TransactionHistoryPage transactionHistoryPage;
    private static ModalPopupsPage modalPopupsPage;
    
	public static StorePage getStorePage(WebDriver driver) {
		/**
		 * Using Ternary Operator: Checking for storePage as null.
		 * 
		 * If it is null, then, create new object and return
		 *
		 * If it is not null, then, return storePage
		 */
		return storePage == null ? new StorePage(driver) : storePage;
	}

	public static LoginsPage getLoginsPage(WebDriver driver) {
		return loginsPage == null ? new LoginsPage(driver) : loginsPage;
	}
	
	public static CustomersPage getCustomersPage(WebDriver driver) {
		return customersPage == null ? new CustomersPage(driver) : customersPage;
	}

	public static CustomerOverviewPage getCustomerOverviewPage(WebDriver driver) {
		return customerOverviewPage == null ? new CustomerOverviewPage(driver) : customerOverviewPage;
	}
	public static DashboardPage getDashboardPage(WebDriver driver) {
		return dashboardPage == null ? new DashboardPage(driver) : dashboardPage;
	}
	public static ExchangePage getExchangePage(WebDriver driver) {
		return exchangePage == null ? new ExchangePage(driver) : exchangePage;
	}
	public static ModalPopupsPage getModalPopupsPage(WebDriver driver) {
		return modalPopupsPage == null ? new ModalPopupsPage(driver) : modalPopupsPage;
	}
	public static TransactionHistoryPage getTransactionHistoryPage(WebDriver driver) {
		return transactionHistoryPage == null ? new TransactionHistoryPage(driver) : transactionHistoryPage;
	}

	public static CheckoutPage getCheckoutPage(WebDriver driver) {
		return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
	}

	public static ProductPage getProductPage(WebDriver driver) {
		return productPage == null ? new ProductPage(driver) : productPage;
	}
	public static CartPage getCartPage(WebDriver driver) {
		return cartPage == null ? new CartPage(driver) : cartPage;
	}
}
