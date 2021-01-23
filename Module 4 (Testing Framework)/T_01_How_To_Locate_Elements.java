package POM_Design_Test_Cases_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import POM_Design_Pages.Home_Page;
import POM_Design_Pages.SignIn_Page;

public class T_01_How_To_Locate_Elements {

	static WebDriver driver;
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


	@Test(priority=1)
	public  void Login_With_Invalid_Email() throws InterruptedException
	{
		Home_Page home= new Home_Page(driver);
		home.signInBtn().click();

		SignIn_Page signIn = new SignIn_Page(driver);
		signIn.EmailField().sendKeys("asw");

		signIn.NextBtn().click();

		Thread.sleep(2000);

		String actualResult;
		actualResult =signIn.error_msg().getText();

		System.out.println(actualResult);
		assertEquals(actualResult, "Couldn't find your Google Account");

	}

	@Test(priority=2)
	public  void Verify_Forgot_Email_URL()
	{
		Home_Page home= new Home_Page(driver);
		home.signInBtn().click();	
		SignIn_Page signIn = new SignIn_Page(driver);

		signIn.Forget_email().click();

		String actualResult;
		actualResult = driver.getCurrentUrl();

		System.out.println(actualResult);
		assertTrue(actualResult.contains("/signin/v2/usernamerecovery"));

	}

	@Test(priority=3)
	public static void Google_Search() {

		Home_Page home=new Home_Page(driver);
		home.SearchField().click();
		home.SearchField().sendKeys("selenium");
		home.SearchField().sendKeys(Keys.ENTER);
		Reporter.log(home.Results_txt().getText());
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(home.Results_txt().getText().contains("46,200,000"), true);
		soft.assertAll();
	}
	@AfterMethod
	public void Go_To_Home_Page(ITestResult result){
		
		if (result.isSuccess()== true){
			System.out.println("Pass");
		}
		else if (result.isSuccess()== false){
			
			System.out.println("Failed");

		}
		driver.navigate().to("https://www.google.com/?hl=eng");

	}

	@AfterTest//After Test
	public static void Close_Driver()
	{
		driver.quit();

	}

}
