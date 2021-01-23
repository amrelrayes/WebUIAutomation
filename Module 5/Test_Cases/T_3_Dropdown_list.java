package Test_Cases;

import org.testng.annotations.Test;

import Pages.P_02_Checkboxes_Page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;


public class T_3_Dropdown_list {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {

		String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		//driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.get("https://the-internet.herokuapp.com/dropdown");
	}
	
	@Test
	public void dropdown_Method_One() throws InterruptedException {
	
		driver.findElement(By.xpath("//option[@value=\"2\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[text()='Option 1']")).click();

	}
	
	@Test
	public void dropdown_Method_Two() throws InterruptedException {
	
		Select select = new Select(driver.findElement(By.id("dropdown")));
		select.selectByValue("2");
		Thread.sleep(3000);
		select.selectByVisibleText("Option 1");
		Thread.sleep(3000);
		select.selectByIndex(0);
		Thread.sleep(3000);
		assertFalse(select.getOptions().get(0).isEnabled());

		assertTrue(select.getOptions().get(1).isEnabled());

	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
