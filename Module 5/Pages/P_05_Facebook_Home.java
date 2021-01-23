package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P_05_Facebook_Home {

	WebDriver driver;
	public P_05_Facebook_Home(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement CreatNewAccount  ()
	{
		return driver.findElement(By.id("id=\"u_0_2\""));
		
	}
	public List<WebElement> SignupList()
	{
		return driver.findElements(By.xpath("//button[@name=\"websubmit\"]"));
	}
	public WebElement CloseBtn()
	{
		return driver.findElement(By.id("id=\"u_2_9\""));
	}
	public By SignupLocator()
	{
		return By.xpath("//button[@name=\"websubmit\"]");

	}
}
