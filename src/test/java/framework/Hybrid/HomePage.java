package framework.Hybrid;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.Homepage;
import resources.Base;

public class HomePage extends Base {
	
	public static Logger log=  LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void browserinitiation() throws IOException{
		driver= initalizeBrowser();
		log.info("Initialize the browser");
		driver.get(prop.getProperty("url"));
		log.info("Loded the hpome page");
	}
	

	@Test
	public void homeScreen() throws IOException{
		
		
		Homepage hp=new Homepage(driver);
		
		Assert.assertEquals(hp.textVisibility().getText(), "An Academy to Learn Ern & Shine  in your QA Career");
		log.info("assertion Passed");
		hp.buttonJ().click();
		log.info("Clicked on button");
		
		
	}
	
	@AfterTest
	public void quitBrowser(){
		driver.quit();
		log.info("Browser quit");
	}

}
