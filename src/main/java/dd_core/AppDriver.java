package dd_core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AppDriver {

	public static WebDriver driver=null;
	public static Properties Config=new Properties();
	public static Properties Obj=new Properties();
	public static Logger log=Logger.getLogger("devpinoyLogger");
	@BeforeMethod
	public void launchApp() throws Exception{
		FileInputStream fis_config=new FileInputStream("F:\\ProjectWorkspace\\MavenFrameWorkProject\\src\\main\\java\\dd_properties\\Config.properties");
		Config.load(fis_config);
		FileInputStream fis_obj=new FileInputStream("F:\\ProjectWorkspace\\MavenFrameWorkProject\\src\\main\\java\\dd_properties\\Object.properties");
		Obj.load(fis_obj);
		if(Config.getProperty("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver.exe");
			driver=new ChromeDriver();
			log.info("Chrome Browser Launches Sucessfully");
		}
		else if(Config.getProperty("browser").equalsIgnoreCase("IE")){
			driver=new InternetExplorerDriver();
			log.info("IE Browser Launches Sucessfull");
		}
		else{
			driver=new FirefoxDriver();
			log.info("FireFox Browser Launches Sucessfull");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Config.getProperty("url"));
	}
	@AfterMethod
	public void logOut(){
		driver.close();
		driver.quit();
	}

}
