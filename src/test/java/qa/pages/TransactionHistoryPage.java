package qa.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TransactionHistoryPage extends BasePage {

	@FindBy(xpath = "//th/div[text()='Status']")
	private WebElement transactionsGridStatusHdr;

	@FindBy(xpath = "//button[text()=\"Transactions\"][@data-state='active']")
	private WebElement transactionsBtn;

	public TransactionHistoryPage(WebDriver driver) {
		super(driver);
	}

	public void verifyTransactionsPageDisplayed() throws InterruptedException {
		Assert.assertTrue(transactionsGridStatusHdr.isDisplayed() && transactionsBtn.isDisplayed(), "Transactions page is displayed");
	}

	public void fillBusinessDetailsInForm(HashMap<String, String> datamap) throws InterruptedException {
		if (datamap == null)
			return;
		for (Map.Entry<String, String> entry : datamap.entrySet()) {
			switch (entry.getKey().toLowerCase()) {
			case "business registration name":
				clearAndSendKeys("business registration name", entry.getValue());
				break;
			case "business registration id":
				clearAndSendKeys("business registration id", entry.getValue());
				break;
			case "registered country":
				clickAndSelectValueForDropdown("Registered country", entry.getValue());
				break;
			case "business operations type":
				clickAndSelectValueForDropdown("business operations type", entry.getValue());
				break;
			case "legal business type":
				clickAndSelectValueForDropdown("legal business type", entry.getValue());
				break;
			case "business address":
				clearAndSendKeys("business address", entry.getValue());
				break;
			case "busines city":
				clearAndSendKeys("busines city", entry.getValue());
				break;
			case "business postal code":
				clearAndSendKeys("business postal code", entry.getValue());
				break;
			case "business province state":
				clearAndSendKeys("business province state", entry.getValue());
				break;
			case "expected monthly turnover amount":
				clearAndSendKeys("Expected monthly turnover amount", entry.getValue());
				break;
			case "turnover currency":
				clearAndSendKeys("turnover currency", entry.getValue());
				break;
			default:
				Assert.assertFalse(true, "Incorrect field name provided");
			}
		}

	}
}
