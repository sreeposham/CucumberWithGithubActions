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
import qa.apis.CartApi;
import qa.context.TestContext;
import qa.domainobjects.Product;
import qa.factory.PageFactoryManager;
import qa.pages.CartPage;

public class CartStepDefinitions {
	private final CartPage cartPage;
	private final TestContext context;

	public CartStepDefinitions(TestContext context) {
		this.context = context;
		cartPage = PageFactoryManager.getCartPage(context.driver);
	}

	@Then("I should see {int} {product} in the cart")
	public void iShouldSeeInTheCart(int quantity, Product product) {
		Assert.assertEquals(product.getName(), cartPage.getProductName());
		Assert.assertEquals(quantity, cartPage.getProductQuantity());
	}

	@And("I have {int} {product} in the cart")
	public void iHaveInTheCart(int quantity, Product product) throws Exception {
//        storePage.addToCart("Blue Shoes");
//		CartApi cartApi = new CartApi(context.cookies.get());
		CartApi cartApi = new CartApi(context.cookies.getCookies());
		product = context.productList.getProductByName(product.getName());
		cartApi.addToCart(product.getId(), quantity);
		// context.cookies.set(cartApi.getCookies());
		context.cookies.setCookies(cartApi.getCookies());
		context.cookies.injectCookiesToBrowser(context.driver);
		context.product = product;
	}
}
