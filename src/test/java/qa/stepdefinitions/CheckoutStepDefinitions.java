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

package qa.stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.context.TestContext;
import qa.enums.EndPoint;
import qa.factory.PageFactoryManager;
import qa.pages.CheckoutPage;

public class CheckoutStepDefinitions {
    private final TestContext context;
    private final CheckoutPage checkoutPage;

    public CheckoutStepDefinitions(TestContext context){
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
    	/*
		 * context.billingDetails -> We are using the same billing details set in
		 * CustomerStepDefinitions (Method: myBillingDetailsAre())
		 */
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }
}
