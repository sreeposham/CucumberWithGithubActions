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

package qa.context;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import qa.domainobjects.BillingDetails;
import qa.domainobjects.Cookies;
import qa.domainobjects.Product;
import qa.domainobjects.ProductList;
import qa.utils.JacksonUtils;

public class TestContext {
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;
    public ProductList productList = new ProductList();
    public Product product;

    /**
	 * Dependency Injection using Pico container
	 */
    public TestContext() throws IOException {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
        productList.addAllProducts(JacksonUtils.deserializeJson("products.json", Product[].class));
    }
}
