package qa.pages;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CustomersPage extends BasePage {
	
	@FindBy(css = "input[name=\"loginfmt\"]")
	private WebElement 	loginemailInputFld;

	@FindBy(css = "input[value=\"Next\"]")
	private WebElement emailNextBtn;

	@FindBy(css = "input[name=\"passwd\"]")
	private WebElement loginPwdInputFld;

	@FindBy(css = "input[value=\"Sign in\"]")
	private WebElement pwdSignInBtn;	

	@FindBy(css = "input[value=\"Yes\"]")
	private WebElement signedInYesBtn;	

	@FindBy(xpath = "//div[text()='Phone']/following-sibling::input")
	private WebElement phoneInputFld;

	@FindBy(css = "input[name=\"emailAddress\"]")
	private WebElement emailInputFld;

	@FindBy(css = "input[name=\"iban\"]")
	private WebElement ibanInputFld;

	@FindBy(css = "input[name=\"fullName\"]")
	private WebElement fullNameInputFld;
	
	@FindBy(xpath = "//button[text()=\"Search\"]")
	private WebElement searchBtn;
	@FindBy(xpath = "//div[@class='selected-flag']")
	private WebElement flagFld;
	@FindBy(xpath = "//input[@class='search-box']")
	private WebElement searchFlagInputFld;	
	@FindBy(xpath = "//img")
	private List<WebElement> images;
	@FindBy(xpath = "//h5[text()='Profile']")
	private WebElement profileLbl;
	public CustomersPage(WebDriver driver) {
		super(driver);
	}
	
	public void loginToAdminPortal(String email, String pwd) {
		clearAndSendKeys(loginemailInputFld, email);
		click(emailNextBtn);
		clearAndSendKeys(loginPwdInputFld, pwd);
		click(pwdSignInBtn);
		click(signedInYesBtn);
	}
	
	public void clickLeftMenuItem(String menu) throws InterruptedException {
		Thread.sleep(2000);
		waitForOverlaysToDisappear(By.xpath("//div[contains(@class,'hide-rocket Muibox-root')]"));
		String raw = "(//span[text()='"+menu+"'][contains(@class,'MuiListItemText-primary')]/ancestor::a)[1]";
		By leftMenu = By.xpath(raw);
//		waitForElementVisibility(leftMenu);
		Thread.sleep(3000);
		waitForElementToBeDisplayed(leftMenu);
		jsClick(leftMenu);
		String header = "(//div[text()='"+menu+"'][contains(@class,'MuiTypography-h4')])[1]";
		waitForElementToBeDisplayed(By.xpath(header));
	}
	
	public void selectPhoneCountry(String country) {
		click(flagFld);
		clearAndSendKeys(searchFlagInputFld, country);
		String raw = "//span[text()='"+country+"'][@class='country-name']/parent::li";
		click(By.xpath(raw));
	}
	
	public void enterPhoneNumber(String country, String phone) throws InterruptedException {
		Thread.sleep(3000);
		waitForElementVisibility(phoneInputFld);
//		String number=phone.split(" ")[1];
		selectPhoneCountry(country);
		clickClearAndSendKeys(phoneInputFld, phone);
	}

	public void enterIBAN(String iban) {
		clearAndSendKeys(ibanInputFld, iban);
	}
	
	public void enterFullName(String name) {
		clearAndSendKeys(fullNameInputFld, name);
	}
	public void enterEmail(String email) {
		clearAndSendKeys(emailInputFld, email);
	}
	
	public void clickSearch() throws InterruptedException {
		Thread.sleep(1000);
		waitForElementToBeClickable(searchBtn);
		actionClick(searchBtn);
	}	
//"//div[contains(@class,'MuiDataGrid-virtualScrollerRenderZone')]/div[@class='MuiDataGrid-row']"
	public void clickCustomerRecord(String searchStr) {
		String strXpath="(//div[@title='"+searchStr+"']/ancestor::div[contains(@class,'MuiDataGrid-row')])[1]";
		By customerRecord = By.xpath(strXpath);
		waitForElementToBeClickable(customerRecord);
		click(customerRecord);
	}
	public void verifyLaunchCustomerOverview() {
		waitForElementVisibility(profileLbl);
		Assert.assertTrue(profileLbl.isDisplayed(), "Customer overview screen is displayed");
	}
}
