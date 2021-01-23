package Test_Cases;

import org.testng.annotations.Test;

import Pages.P_02_Checkboxes_Page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;


public class T_5_Conditional_Syn_Implicit {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {

		String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		//driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
		
	}
	
	
	@Test
	public void Presence() throws InterruptedException {
	
	driver.findElement(By.id("id=\"u_0_2\"")).click();
    assertTrue(driver.findElements(By.xpath("//button[@name=\"websubmit\"]")).size() == 1);
    driver.findElement(By.id("id=\"u_2_9\"")).click();
  //  assertTrue(driver.findElements(By.xpath("//button[@name=\"websubmit\"]")).size() == 0);

	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
