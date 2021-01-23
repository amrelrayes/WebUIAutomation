package Test_Cases;

import org.testng.annotations.Test;

import Pages.P_02_Checkboxes_Page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


public class T_2_Checkboxes {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {

		String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		//driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.get("https://the-internet.herokuapp.com/checkboxes");
	}
	
	@Test
	public void Checkbox() {
		Boolean check;
		P_02_Checkboxes_Page p02 = new P_02_Checkboxes_Page(driver);
	
		check = 	p02.Checkbox("1").isSelected();

		assertFalse(check);

		p02.Checkbox("1").click();
		check =	p02.Checkbox("1").isSelected();

		assertTrue(check);

		check = 	p02.Checkbox("2").isSelected();

		assertTrue(check);


	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
