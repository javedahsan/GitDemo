package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class actionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//firfox driver -- geckodriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.com/");
		
//		 Action class
//		
//		create Actions object
//		apply action on object with build
//		then perform action 
		
		Actions a = new Actions(driver);
		// mouse over example
		
		//a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		//move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		
		// search with Capital letters
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
//		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
				
		// select doubleclick
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		
		a.moveToElement(move).build().perform();
		
	}

}
