package POM_Design_Test_Cases_TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Design_Pages.Home_Page;
import POM_Design_Pages.SignIn_Page;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	

		 WebDriver driver;
		SignIn_Page signIn = new SignIn_Page(driver);



		@BeforeTest//Before Test
		public  void Launch_Browser()
		{

			String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.navigate().to("https://www.google.com/?hl=ar");

			driver.findElement(By.partialLinkText("Eng")).click();
}
	
	@Test(priority=3)
	public void Google_Search() {

		Home_Page home=new Home_Page(driver);
		home.SearchField().click();
		home.SearchField().sendKeys("selenium");
		home.SearchField().sendKeys(Keys.ENTER);
		Reporter.log(home.Results_txt().getText());
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(home.Results_txt().getText().contains("46,200,000"), true);
		soft.assertAll();
	}
	
	
}
	
