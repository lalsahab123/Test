package dd_main;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import dd_core.AppDriver;
import dd_screen.Homepage;

public class MainTest extends AppDriver{
	Homepage home;
	public MainTest(){
		super();
		home=new Homepage();
	}
	
	
	@Test
	public void signUp(){
		home.clickOnSignUpButon();
		home.clickOnNextButton();
		home.fillDetails();
	}
	
	/*@Test
	public void verifyDashboard(){
		log.info("Check dashboard functionality");
	}*/

}
