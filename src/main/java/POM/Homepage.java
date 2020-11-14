package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

	public WebDriver driver;
	private By signup=By.cssSelector("a[href*='sign_in']");

	private By titletext=By.xpath("//span[text()='An Academy to ']");
	private By Joinbutton=By.xpath("//div[@class='header-text hidden-xs'] //a[text()='JOIN NOW']");
	
	
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}




	public Loginpageobjects Login(){
		
		driver.findElement(signup).click();
		return new Loginpageobjects(driver);
		
		
	}
	
	public WebElement textVisibility(){
	 return driver.findElement(titletext);	
	}
	
	public WebElement buttonJ(){
		return driver.findElement(Joinbutton);
	}
}

