package Test_Cases;

import org.testng.annotations.Test;

import Pages.P_01_Login_Page;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.AfterTest;

public class T_1_Textboxes_Buttons {
	WebDriver driver;
  @Test
  public void Get_URL() {
	  P_01_Login_Page p01 = new P_01_Login_Page(driver);
	  p01.Elemental_Selenium().getText();
	  String URL;
	 URL= p01.Elemental_Selenium().getAttribute("href");
	 assertEquals(URL, "http://elementalselenium.com/");
	  
  }
  @Test
  public void Get_COLOR() throws InterruptedException {
	  P_01_Login_Page p01 = new P_01_Login_Page(driver);
	  p01.Login_Btn().click();
	  Thread.sleep(2000);
	  String Color;
Color= p01.flash_error().getCssValue("background-color");
	System.out.println(Color);
	  
  }
  private void Click() {
	// TODO Auto-generated method stub
	
}
@BeforeTest
  public void beforeTest() {

		String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		//driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.get("https://the-internet.herokuapp.com/login");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
