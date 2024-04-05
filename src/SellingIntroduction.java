import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SellingIntroduction {

	public static void main(String[] args) {
		
		// invoking browser
		// Chrome - ChromeDriver - Methods - close
		// Firefox - firefoxDriver - Methods - close
		// safari - safariDriver - Methods - close get 
		// create object of class to access the methods
		// there is interface on top of all classes - WebDriver
		
		// Webdriver methods + class methods
		
		// ChromeDriver driver = new ChromeDriver();
		
		// step to invoke ChromeDriver 
		
		// Selenium Manager on - beta phase if chromedriver path is not define, otherwise off
		
		System.setProperty("webdriverchrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// latest selenium version use Selenium manager to invoke latest chrome browser
		
		// chromedriver
		WebDriver driver = new ChromeDriver();
		
//		//firfox driver -- geckodriver
//		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\geckodriver.exe");
//		 WebDriver driver1 = new FirefoxDriver();
//		
//		//ms edge driver -- msedgedriver
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\msedgedriver.exe");
//		WebDriver driver2 = new EdgeDriver();
				
		
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
		
		
	}
	

}
