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

public class ModalPopupsPage extends BasePage {

	@FindBy(xpath = "//button[text()='Promote account to business']")
	private WebElement promoteBusinessBtn;

	@FindBy(xpath = "//h6[text()=\"Please enter business details\"]")
	private WebElement promoteBusinessFormHdr;

	@FindBy(xpath = "//button[text()=\"Submit\"]")
	private WebElement submitBtn;

	@FindBy(xpath = "//h5[text()='Profile']")
	private WebElement profileLbl;

	public ModalPopupsPage(WebDriver driver) {
		super(driver);
	}

	public void openPromoteToBusinessForm() throws InterruptedException {
		waitForElementToBeDisplayed(promoteBusinessBtn);
		jsClick(promoteBusinessBtn);
		waitForElementToBeDisplayed(promoteBusinessFormHdr);
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

	public void clickSubmitBtn() throws InterruptedException{
		jsClick(submitBtn);
		waitForElementToBeDisplayed(profileLbl);
	}

	public void editCustomerStatus(String statusLabel, String status, String remarks) throws InterruptedException {
		Thread.sleep(2000);
		By statusEditFld=By.xpath("//p[text()='"+statusLabel+"']/following-sibling::div//button");
		waitForElementToBeDisplayed(statusEditFld);
		jsClick(statusEditFld);
		By statusEditFormHdr=By.xpath("//h2[text()='Set "+statusLabel.toLowerCase()+"']");
		waitForElementToBeDisplayed(statusEditFormHdr);
		SelectValueForDropdown("Status",status);
		clearAndSendKeys(driver.findElement(By.xpath("//textarea[@name='note']")),remarks);
		Thread.sleep(3000);
		Actions act = new Actions(driver);		   
		   act.sendKeys(Keys.TAB).build().perform();
		   act.sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(3000);
	}

	public void verifyAlertMessage(String msgText) {
		try {
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//div[@class='SnackbarItem-message']")).getText());
//			By byAlert=By.xpath("//div[@class='SnackbarItem-message'][.='"+msgText+"']");
			By byAlert=By.xpath("//div[@class='SnackbarItem-message']");
			Assert.assertTrue(driver.findElement(byAlert).getText().equals(msgText), "Toast Alert Message: '"+msgText+"' is not displayed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void verifyBusinessUserStatusCheck() throws InterruptedException {
		//verify promoted to business button not available
		//Business verification status Approved
		Assert.assertTrue(!checkElementDisplayed(promoteBusinessBtn), "Customer is not promoted, hence Promote to business button is still available");
		verifyUserStatus("Business verification status","APPROVED");
	}
	
	public void verifyUserStatus(String statusLvl, String status) {
		By statusCheck=By.xpath("//p[text()='"+statusLvl+"']/following-sibling::div/p");
		String actStatus=driver.findElement(statusCheck).getText().trim();
		Assert.assertTrue(status.toUpperCase().equals(actStatus),"User '"+statusLvl+"' actual status: '"+actStatus+"'");
	}
}
