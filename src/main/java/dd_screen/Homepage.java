package dd_screen;

import org.openqa.selenium.By;

import dd_core.AppDriver;
import dd_core.Library;

public class Homepage extends AppDriver{
	Library library;
	public Homepage(){
		library=new Library();
	}

	public void clickOnSignUpButon(){
		log.info("click on signup button");
		//driver.findElement(By.id(Obj.getProperty("signUP_btn"))).click();
		library.clickOnAnyElement(Obj.getProperty("signUP_btn"), "id", "click");
	}
	public void clickOnNextButton(){
		log.info("click on next button");
		//driver.findElement(By.xpath(Obj.getProperty("next_btn"))).click();
		library.clickOnAnyElement(Obj.getProperty("next_btn"), "xpath", "keys");
	}
	public void fillDetails(){
		log.info("Fill User Detais");
		//driver.findElement(By.xpath(Obj.getProperty("signUp_EmailAddress"))).sendKeys("lal12.chaudhary");
		library.send_To_TextBox(Obj.getProperty("signUp_EmailAddress"), "xpath", "lal12.chaudhary");
	}
}
