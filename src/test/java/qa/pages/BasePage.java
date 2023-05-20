package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.utils.ConfigLoader;

import static qa.constants.FrameworkConstants.ATTRIBUTE_VALUE;
import static qa.constants.FrameworkConstants.EXPLICIT_WAIT;

import java.time.Duration;
import java.util.List;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	Actions	actions;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	public void load(String endPoint) {
		driver.get(endPoint);
		
	}
	
	public WebElement getElement(String loc) {
		return driver.findElement(By.xpath("//*[text()='"+loc+"']"));
	}
	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if (overlays.size() > 0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	public void clickClearAndSendKeys(WebElement element, String value) {
		if (value==null) return;
		element = waitForElementVisibility(element);
		actionClick(element);
		element.clear();
		element.sendKeys(value);
	}
	
	public void clearAndSendKeys(WebElement element, String value) {
		if (value==null) return;
		element = waitForElementVisibility(element);
		element.clear();
		element.sendKeys(value);
	}
	
	public void clearAndSendKeys(String label, String value) {
		if (value==null) return;
		WebElement labelInputFld=driver.findElement(By.xpath("//label[text()='"+label+"']/following-sibling::div/input"));
		clearAndSendKeys(labelInputFld,value);
	}
	
	public void click(WebElement element) {
		waitForElementToBeClickable(element).click();
	}

	public void click(By by) {
		WebElement ele=driver.findElement(by);
		click(ele);
	}
	
	public void actionClick(WebElement element) {
		waitForElementToBeClickable(element);
		actions.moveToElement(element).click().perform();
	}

	public void actionClick(By by) {
		WebElement ele=driver.findElement(by);
		actionClick(ele);
	}
	
	public void jsClick(WebElement element) {
		waitForElementToBeClickable(element);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void jsClick(By by) {
		WebElement ele=driver.findElement(by);
		jsClick(ele);
	}	

	public WebElement waitForElementVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitForElementVisibility(By by) {
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
	}

	public void waitForElementToBeDisplayed(By by) throws InterruptedException {
		WebElement ele=driver.findElement(by);
		waitForElementToBeDisplayed(ele);

	}
	
	public void waitForElementToBeDisplayed(WebElement element) throws InterruptedException {
		int i = 0;
		while (i <= 10) {
			try {
				if (element.isDisplayed()) {
					break;

				}{
					i++;
				}
			} catch (Exception e) {
				i++;
				Thread.sleep(3000);
			}
		}

	}
	
	public void clickAndSelectValueForDropdown(String label, String value) {
		if (value==null) return;
		WebElement fldLabel=driver.findElement(By.xpath("//label[text()='"+label+"']/following-sibling::div/div"));
		fldLabel.click();
		WebElement option=driver.findElement(By.xpath("//li[@role='option'][text()='"+value+"']"));
		scrollToElement(option);
		option.click();
	}

	public void SelectValueForDropdown(String label, String value) {
		if (value==null) return;
		WebElement fldLabel=driver.findElement(By.xpath("//label[text()='"+label+"']/following-sibling::div//select"));
		fldLabel.click();
		WebElement option=driver.findElement(By.xpath("//option[text()='"+value+"']"));
		scrollToElement(option);
		option.click();
	}
	
	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForElementToBeClickable(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getElementText(WebElement element) {
		return waitForElementVisibility(element).getText();
	}

	public String getElementElementAttribute_Value(WebElement element) {
		return waitForElementVisibility(element).getAttribute(ATTRIBUTE_VALUE);
	}

	public String getElementElementCustomAttribute(WebElement element, String customAttribute) {
		return waitForElementVisibility(element).getAttribute(customAttribute);
	}
	
	public boolean checkElementDisplayed(WebElement ele) throws InterruptedException {
		boolean flag=false;
		try {
			if(ele.isDisplayed()){
				flag=true;
				
			}
		}catch(Exception e) {
			waitForElementToBeDisplayed(ele);
			try {
			if(ele.isDisplayed())
				flag=true;
			}catch(Exception ex) {
			flag=false;}
		}
		return flag;
	}
	
	public boolean checkElementDisplayed(By by) throws InterruptedException {
		WebElement ele=driver.findElement(by);
		return checkElementDisplayed(ele);
	}

}
