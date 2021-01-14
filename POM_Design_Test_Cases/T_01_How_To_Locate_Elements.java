package POM_Design_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Design_Pages.Home_Page;
import POM_Design_Pages.SignIn_Page;

public class T_01_How_To_Locate_Elements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Launch_Browser();

		Login_With_Invalid_Email();
	
		Verify_Forgot_Email_URL();
		
		Google_Search();

		Close_Driver();
		

	}



//Before Test
public static void Launch_Browser()
{
	
	String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", chromePath);
	driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.navigate().to("https://www.google.com/?hl=ar");

	driver.findElement(By.partialLinkText("Eng")).click();
}


//Test Case 1: Login without using email field
public static void Login_With_Invalid_Email() throws InterruptedException
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
	System.out.println(actualResult.contains("Couldn't find your Google Account"));

}

//Test Case 2: Get forget email url
public static void Verify_Forgot_Email_URL()
{
	SignIn_Page signIn = new SignIn_Page(driver);

	signIn.Forget_email().click();

	String actualResult;
	actualResult = driver.getCurrentUrl();
	
	System.out.println(actualResult);
	System.out.println(actualResult.contains("/signin/v2/usernamerecovery"));

}

//Test Case 3: Google Search
public static void Google_Search() {
	driver.navigate().to("https://www.google.com/?hl=eng");
	
	Home_Page home=new Home_Page(driver);
	home.SearchField().click();
	home.SearchField().sendKeys("selenium");
	home.SearchField().sendKeys(Keys.ENTER);
	System.out.println(driver.findElement(By.id("result-stats")).getText());
	System.out.println(driver.findElement(By.id("result-stats")).getText().contains("46,200,000"));
	
}


//After Test
public static void Close_Driver()
{
	driver.quit();

}

}
