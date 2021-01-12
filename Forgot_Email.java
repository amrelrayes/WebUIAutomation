package Open_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forgot_Email {
	public static void main (String[] args) throws InterruptedException {
		
		String chromePath = (System.getProperty("user.dir") + "\\Browsers\\chromedriver.exe");
	
		System.setProperty("webdriver.chrome.driver",chromePath);
		WebDriver driver= new ChromeDriver ();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/?hl=en");
		driver.findElement(By.id("gb_70")).click();
		driver.findElement(By.xpath("//button[text()=\"Forgot email?\"]")).click();
		Thread.sleep(2000);
		String getUrl= driver.getCurrentUrl();
		System.out.println(getUrl);
		System.out.println(getUrl.contains("/signin/v2/forgotemail"));
		
		driver.quit();
	}
	
}