package qa.pages;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class ExchangePage extends BasePage {
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement 	nextBtn;
	@FindBy(css = "input[id=\"amount\"]")
	private WebElement 	buyAmountInputFld;
	@FindBy(xpath = "//button[text()='Confirm Exchange']")
	private WebElement 	confirmExchangeAmountBtn;
	@FindBy(xpath = "//button[text()='Done']")
	private WebElement 	doneBtn;	
	@FindBy(xpath = "//div[@role='dialog']//h2[text()='Success']")
	private WebElement 	successTitleLbl;	
	
	public ExchangePage(WebDriver driver) {
		super(driver);
	}
	
	public void enterBuyCurrencyAmount(String amount, String currency) {
		SelectValueForDropdown("Buying", currency);
		clearAndSendKeys(buyAmountInputFld, amount);
	}

}
