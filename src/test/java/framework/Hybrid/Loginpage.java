package framework.Hybrid;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.ForgotPassword;
import POM.Homepage;
import POM.Loginpageobjects;
import resources.Base;

public class Loginpage extends Base {
	public WebDriver driver;
	public static Logger log=   LogManager.getLogger(Base.class.getName());
	
	
	@BeforeTest
	public void startBrowser() throws IOException{
		driver= initalizeBrowser();
		log.info("Initialize the browser");
		driver.get(prop.getProperty("url"));
		log.info("Loded the hpome page");
		
	}
	
	@Test
	public void Loginpage(){
		Homepage hp=new Homepage(driver);
		Loginpageobjects lpo=hp.Login();
		log.info(" login Page loaded successfully");
		
		Assert.assertEquals(lpo.title().getText(), "Log In to Rahul Shetty Academy");
		
	}
	
	@AfterTest
	public void quitBrowser(){
		
		driver.quit();
		log.info("Browser quit");
	}
	
	@Test(dataProvider="getData")
public void login(String username, String password){
		Loginpageobjects lpo=new Loginpageobjects(driver);
		lpo.username().sendKeys(username);
		log.info("Entered username");
		lpo.password().sendKeys(password);
		log.info("Entered password");
		lpo.submit().click();
		log.info("submitt clicked");
		
		ForgotPassword fp=lpo.forgotPassword();
		fp.emailAddress().sendKeys("xxxxxx");
		fp.sendMeNotifications().click();
		Assert.assertTrue(fp.alertButton().isDisplayed());
	
}
	
	@Test
	public void lostpwd(){
		Loginpageobjects lpo=new Loginpageobjects(driver);
		ForgotPassword fp=lpo.forgotPassword();
		fp.emailAddress().sendKeys("xxxxxx");
		fp.sendMeNotifications().click();
		Assert.assertTrue(fp.alertButton().isDisplayed());

		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Object data[][]=new Object[3][2];
		data[0][0]="wasim";
		data[0][1]="123";
		data[1][0]="Basha";
		data[1][1]="123";
		data[2][0]="rahul";
		data[2][1]="123";
		
		return data;
	}

}
