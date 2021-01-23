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


public class T_4_Check_Presence_Method_two {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {

		String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		//driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.get("https://www.facebook.com/");
	}
	
	
	@Test
	public void Presence() throws InterruptedException {
	Thread.sleep(2000);
	
	driver.findElement(By.id("id=\"u_0_2\"")).click();
	Thread.sleep(2000);
    assertTrue(driver.findElements(By.xpath("//button[@name=\"websubmit\"]")).size() == 1);
    driver.findElement(By.id("id=\"u_2_9\"")).click();
	Thread.sleep(2000);
    assertTrue(driver.findElements(By.xpath("//button[@name=\"websubmit\"]")).size() == 0);

	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
