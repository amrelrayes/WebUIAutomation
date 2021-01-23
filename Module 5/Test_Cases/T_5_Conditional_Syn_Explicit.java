package Test_Cases;

import org.testng.annotations.Test;

import Pages.P_02_Checkboxes_Page;
import Pages.P_05_Facebook_Home;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class T_5_Conditional_Syn_Explicit {
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
		P_05_Facebook_Home p05= new P_05_Facebook_Home(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		p05.CreatNewAccount().click();
		
		//	driver.findElement(By.id("id=\"u_0_2\"")).click();
		assertTrue( p05.SignupList().size()== 1);
		System.out.println("Debug0");
		p05.CloseBtn().click();
		System.out.println("Debug1");
		//driver.findElement(By.id("id=\"u_2_9\"")).click();
		wait.until(ExpectedConditions.numberOfElementsToBe(p05.SignupLocator(), 0));
		wait.until(ExpectedConditions.visibilityOf(p05.CreatNewAccount())).click();

		//  assertTrue(driver.findElements(By.xpath("//button[@name=\"websubmit\"]")).size() == 0);
		System.out.println("Debug2");
		
		FluentWait flwait= new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
		wait.until((driver)-> assert)

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
