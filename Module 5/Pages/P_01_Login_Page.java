package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P_01_Login_Page {

	WebDriver driver;
	public P_01_Login_Page(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement Elemental_Selenium ()
	{
		return driver.findElement(By.xpath("//a[@target=\"_blank\"]"));
		
	}
	public WebElement flash_error ()
	{
		return driver.findElement(By.id("flash"));
	}
	public WebElement Login_Btn ()
	{
		return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
	}
}
