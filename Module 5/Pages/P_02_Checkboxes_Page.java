package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P_02_Checkboxes_Page {

	WebDriver driver;
	public P_02_Checkboxes_Page(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement Checkbox  (String num)
	{
		return driver.findElement(By.xpath("(//input[@type=\"checkbox\"])["+num+"]"));
		
	}
	
}
