package qa.pages;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class LoginsPage extends BasePage {
	
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

	@FindBy(name="email")
	WebElement corp_login_emailInput;
	
	@FindBy(name="password")
	WebElement corp_login_pwdInput;

	@FindBy(xpath="//button[text()='Next']")
	WebElement corp_login_nextBtn;	
	
	public LoginsPage(WebDriver driver) {
		super(driver);
	}
	
	public void loginMicrosoft(String email, String pwd) {
		clearAndSendKeys(loginemailInputFld, email);
		click(emailNextBtn);
		clearAndSendKeys(loginPwdInputFld, pwd);
		click(pwdSignInBtn);
		click(signedInYesBtn);
	}

	public void loginCorpPortal(String email, String password) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			if (loginemailInputFld.isDisplayed()) {
				System.out.println("inside try");
				loginMicrosoft(email, password);
			}
		} catch (Exception e) {
			System.out.println("Microsoft Authentication is not triggered");
		}
//		System.out.println("After try");
		corp_login_emailInput.sendKeys(email);
		corp_login_pwdInput.sendKeys(password);
		corp_login_nextBtn.click();
	}

	
	//	public void loginMicrosoft(String email, String pwd) {
//		System.out.println("inside Microsoft");
//		loginemailInputFld.sendKeys(email);
//		emailNextBtn.click();
//		loginPwdInputFld.sendKeys(pwd);
//		pwdSignInBtn.click();
//		signedInYesBtn.click();
//	}
	


}
