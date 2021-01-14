package POM_Design_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	
WebDriver driver;

	public Home_Page(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement signInBtn(){
		
	return	driver.findElement(By.id("gb_70"));

	}
	public WebElement SearchField(){
		
	return driver.findElement(By.name("q"));
	
	}
	
}
