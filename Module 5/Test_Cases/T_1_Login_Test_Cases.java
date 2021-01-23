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

public class T_1_Login_Test_Cases {
	WebDriver driver;
  @Test
  public void Invaild_Username() {
	
	  
  }
  @Test
  public void Valid_Username () throws InterruptedException {

	  
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
