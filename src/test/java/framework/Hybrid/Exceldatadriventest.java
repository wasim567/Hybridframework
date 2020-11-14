package framework.Hybrid;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.Homepage;
import POM.Loginpageobjects;
import resources.Base;
import resources.Dataexcel;

public class Exceldatadriventest extends Base{
	
	public WebDriver driver;
	
	
	@BeforeTest
	public void driverInitialization() throws IOException{
		driver=initalizeBrowser();
		driver.get(prop.getProperty("url"));
		
		
	}
	
	@Test
	public void logintest() throws IOException{
		Homepage hp=new Homepage(driver);
		Loginpageobjects lp= hp.Login();
		Dataexcel de=new Dataexcel();
		ArrayList l=de.dataHub("Applications");
		lp.username().sendKeys(l.get(0).toString());
		lp.password().sendKeys(l.get(1).toString());
		lp.submit().click();
		
	
	}
	@AfterTest
	public void coseDriver(){
		driver.quit();
	}

}
