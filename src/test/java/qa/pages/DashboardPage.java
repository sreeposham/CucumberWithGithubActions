package qa.pages;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class DashboardPage extends BasePage {
	
	@FindBy(xpath = "//h1[text()='Dashboard']")
	private WebElement 	dashbrdTitle;

	@FindBy(xpath = "//a[text()='Send']")
	private WebElement 	sendBtn;
	
	@FindBy(xpath = "//a[text()='Exchange']")
	private WebElement 	exchangeBtn;

	@FindBy(xpath = "//button[text()='Add funds']")
	private WebElement 	addFundsBtn;

	@FindBy(xpath = "//button[text()='Withdraw']")
	private WebElement 	withdrawBtn;

	@FindBy(xpath = "//a[text()='Send international']")
	private WebElement 	sendInternationalBtn;
	

	@FindBy(xpath = "//button[text()='Transactions']")
	private WebElement 	transactionsTabLink;
	
	@FindBy(xpath = "//p[text()='British Pound Sterling']/parent::div")
	private WebElement gbpWalletCard;	
	@FindBy(xpath = "//button[text()='Check rate calculator']")
	private WebElement 	rateCalculatorLink;
	
	
	By exchangeHdr=By.xpath("//h1[text()='Exchange']");
	By paymentsHdr=By.xpath("//h1[text()='Payments']");
	By addFundsHdr=By.xpath("//h2[text()='Add funds']");
	By withdrawFundsHdr=By.xpath("//h2[text()='Withdraw funds']");


	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyDashboardIsDisplayed() {
		try {
			waitForElementToBeDisplayed(dashbrdTitle);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(dashbrdTitle.isDisplayed(), "Dashboard page is displayed");
	}
	
	public void clickButtonDashboardPage(String btn) {
		if (btn.equals(null)) return;
		switch(btn.toUpperCase()) {
		case "SEND": 
			click(sendBtn);
			break;
		case "EXCHANGE": 
			jsClick(exchangeBtn);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "ADD FUNDS": 
			click(addFundsBtn);
			break;
		case "WITHDRAW": 
			click(withdrawBtn);
			break;
		case "TRANSACTIONS": 
			click(transactionsTabLink);
			break;
		case "INTERNATIONAL PAYMENTS":
			actionClick(sendInternationalBtn);
			break;			
		}

	}
	public void verifyPageNavigation(String page) throws InterruptedException {
		if(page.equals(null)) return;
		switch(page.toUpperCase()) {
		case "EXCHANGE":
			waitForElementToBeDisplayed(exchangeHdr);
			Assert.assertTrue(checkElementDisplayed(exchangeHdr));
			break;
		case "ADD FUNDS": 
			Assert.assertTrue(checkElementDisplayed(addFundsHdr)); break;
		case "WITHDRAW": 
			Assert.assertTrue(checkElementDisplayed(withdrawFundsHdr)); break;
		case "SEND": 
			Assert.assertTrue(checkElementDisplayed(paymentsHdr)); break;
		case "INTERNATIONAL PAYMENTS": 
			Assert.assertTrue(checkElementDisplayed(rateCalculatorLink)); break;
		}
	}

}
