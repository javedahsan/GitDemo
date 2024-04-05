import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\msedgedriver.exe");
		
		//driver.findElement(By.name("username"));s\\user\\DevTools\\WbDrivers\\msedgechromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		// depricated
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//WebDriver driver = new EdgeDriver();
		
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		//find image
		//WebElement retImg = driver.findElement(By.tagName("img"));
		
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]")));
		
		String retImg = driver.findElement(By.tagName("h1")).getText();
		
		System.out.println(retImg);
		
		//find content
		
		
		//find usernam
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahual");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		
		//CSS selector
		

		//by CSS selector
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		// by link Text
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//pause for millisend
		Thread.sleep(2000);
		// xpath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Javed");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Javed@rsa.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Javed@rsa.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9056678976");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		Thread.sleep(1000);
		//# use for by id in Css
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement (By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		//driver.findElement(By.id("chkboxOne")).click();
		
		// xpath by regular expression
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		
		
		
		
		// multiple values
		
		// find forget password link is '
		//find footer
		
		
		
		
		//driver.close();
		// close current window
		//driver.quit();
		// close all the browsers
		
	}

}
