package Open_Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge_Browser {
	public static void main (String[] args) {
		
		String edgePath = (System.getProperty("user.dir") + "\\Browsers\\MicrosoftWebDriver.exe");
	
		System.setProperty("webdriver.edge.driver", edgePath);
		
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		driver.quit();
	}
	
}