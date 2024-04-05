import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locator2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "rahul";
//		Chrome Browser
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
//		FireFox Browser
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
	    
//		MS edge browers
		System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
	
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//dynamically get password and insert here
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement (By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		String actRslt = driver.findElement(By.tagName("p")).getText();
		
		System.out.println(actRslt);
		String expRslt = "You are successfully logged in.";
		
		Assert.assertEquals(actRslt, expRslt);
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " +name +",");
		driver.findElement(By.className("logout-btn")).click();
		//driver.findElement(By.xpath("*[text()='LOG OUT']")).click();
		driver.close();
		
		}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// by link Text
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		
		String [] passwordArray = passwordText.split("'");
		
		// passwordArray[0] -- 0th index
		// passwordArray[1] -- 1th index
		String password = passwordArray[1].split("'")[0];
		
		return password;
				
		
		
		
				
		
	}

}
