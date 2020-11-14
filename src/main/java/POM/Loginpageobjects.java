package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpageobjects {
	
	public WebDriver driver;

	private By Title=By.xpath("//div[@class='content-box']/h1");
	private By Username=By.id("user_email");
	private By Password=By.id("user_password");
	private By Submit=By.xpath("//input[@type='submit']");
	private By Forgotpassword=By.cssSelector("[href*='password/new']");
	public Loginpageobjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement title(){
		return driver.findElement(Title);
	}
	
	public WebElement username(){
		return driver.findElement(Username);
	}
	
	public WebElement password(){
		return driver.findElement(Password);
	}
	
	public WebElement submit(){
		return driver.findElement(Submit);
	}
	
	public ForgotPassword forgotPassword(){
		driver.findElement(Forgotpassword).click();
		
		return new ForgotPassword(driver);
	}
	

}
