package Test_Cases;

import org.testng.annotations.Test;

import Pages.P_02_Checkboxes_Page;
import Pages.P_05_Facebook_Home;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import org.testng.annotations.BeforeTest;
import org.omg.PortableServer.THREAD_POLICY_ID;
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


public class T_6_Multi_Windows {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		//driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);

	}


	@Test
	public void Handling_New_Tab() throws InterruptedException {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());

		driver.findElement(By.xpath("//a[@target=\"_blank\" and text()=\"Elemental Selenium\"]")).click();
		Thread.sleep(2000);
		
		Set<String> WindowHandle = driver.getWindowHandles();
		ArrayList<String> Tabs = new ArrayList<>(WindowHandle);
		
		driver.switchTo().window(Tabs.get(1));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());

		driver.switchTo().window(Tabs.get(0));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
