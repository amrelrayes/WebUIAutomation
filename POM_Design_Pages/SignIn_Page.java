package POM_Design_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn_Page {
	
	WebDriver driver;
	
	public SignIn_Page(WebDriver driver){
		this.driver = driver;
	}

	public WebElement EmailField(){
		
	return driver.findElement(By.cssSelector("input[aria-label=\"Email or phone\"]"));

	}
	public WebElement NextBtn(){
		return 	driver.findElement(By.xpath("//button[@jscontroller=\"soHxf\" and @jsname=\"LgbsSe\"]"));
		
	}
	public WebElement error_msg(){
		return driver.findElement(By.xpath("//div[@jsname=\"B34EJ\"]/div[@class=\"o6cuMc\"]"));
		
	}
	public WebElement Forget_email(){
		return driver.findElement(By.xpath("//button[@jsname=\"Cuz2Ue\"]"));
	}
}
