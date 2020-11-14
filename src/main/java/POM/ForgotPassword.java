package POM;


	
	

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class ForgotPassword {

		public WebDriver driver;
		private By emailAddress=By.id("user_email");
		private By sendMeNotifications=By.xpath("//input[@type='submit']");
		private By alertButton=By.xpath("//button[@class='close']");
		
		public ForgotPassword(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
		}
		
		
		public WebElement emailAddress(){
			
			
			return driver.findElement(emailAddress);
		}


		public WebElement sendMeNotifications(){
			
			
			return driver.findElement(sendMeNotifications);
		}

		
public WebElement alertButton(){
			
			
			return driver.findElement(alertButton);
		}

		
	}




