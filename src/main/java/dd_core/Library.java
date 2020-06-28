package dd_core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Library extends AppDriver{
	public WebElement get_WebElement_Object(String locator,String locator_type){

		WebElement Object=null;
		if(locator_type.equalsIgnoreCase("xpath")){
			//Object=driver.findElement(By.xpath(locator));
			Object=fluentWaitForWebElements(By.xpath(locator));
		}
		else if(locator_type.equalsIgnoreCase("name")){
			//Object=driver.findElement(By.name(locator));
			Object=fluentWaitForWebElements(By.name(locator));
		}
		else if(locator_type.equalsIgnoreCase("id")){
			//Object=driver.findElement(By.id(locator));
			Object=fluentWaitForWebElements(By.id(locator));
		}
		else if(locator_type.equalsIgnoreCase("linktext")){
			//Object=driver.findElement(By.linkText(locator));
			Object=fluentWaitForWebElements(By.linkText(locator));
		}
		else if(locator_type.equalsIgnoreCase("partiallinktext")){
			//Object=driver.findElement(By.partialLinkText(locator));
			Object=fluentWaitForWebElements(By.partialLinkText(locator));
		}
		else if(locator_type.equalsIgnoreCase("tagname")){
			//Object=driver.findElement(By.tagName(locator));
			Object=fluentWaitForWebElements(By.tagName(locator));
		}
		else if(locator_type.equalsIgnoreCase("classname")){
			//Object=driver.findElement(By.className(locator));
			Object=fluentWaitForWebElements(By.className(locator));
		}
		else if(locator_type.equalsIgnoreCase("cssselect")){
			Object=fluentWaitForWebElements(By.cssSelector(locator));
		}
		return Object;
	}
	public WebElement fluentWaitForWebElements(final By locator){
		final Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				//return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				try {
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
				} catch (Exception e) {
				}
				return driver.findElement(locator);
			}
		});
		return foo;
	}

	public WebElement WebDriverWaitForElements(By locator){
		WebDriverWait wait=new WebDriverWait(driver,20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void scrollIntoView(By locator){
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
	}

	public void clickOnAnyElement(String locator, String locator_type, String click_type){
		WebElement Object=null;
		Object = get_WebElement_Object(locator, locator_type);
		if(click_type.equalsIgnoreCase("click")){
			Object.click();	
		}
		else if(click_type.equalsIgnoreCase("javascript")){
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", Object);
		}
		else if(click_type.equalsIgnoreCase("keys")){
			Object.sendKeys(Keys.CONTROL);
			Object.sendKeys(Keys.ENTER);
			
		}
	}
	public void send_To_TextBox(String locator, String locator_type, String TexttoSend){
		WebElement Object=null;
		Object = get_WebElement_Object(locator, locator_type);
		Object.clear();
		Object.sendKeys(TexttoSend);
	}
	public void singleDropDownSelect(String locator, String locator_type, String TextToSelect, String Select_Type){
		WebElement Object=null;
		Select sel=null;
		Object = get_WebElement_Object(locator, locator_type);
		if(Object!=null){
			sel=new Select(Object);
		}
		if(Select_Type.equalsIgnoreCase("value")){
			sel.selectByValue(TextToSelect);
		}
		if(Select_Type.equalsIgnoreCase("text")){
			sel.selectByVisibleText(TextToSelect);
		}
		if(Select_Type.equalsIgnoreCase("index")){
			sel.selectByIndex(Integer.parseInt(TextToSelect));
		}
	}
	
}
