import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

class ExeEndToEnd {

	public static void main(String[] args) throws InterruptedException {
		// Exercise 2 end to end project
		System.setProperty("webdriverchrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		// input Name
		
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Javed Mohammad");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("javed@telus.com");
		driver.findElement(By.id("exampleInputPassword1")).clear();
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("test123");
		driver.findElement(By.id("exampleCheck1")).click();
		// validate if it is selected
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isEnabled());
		
		Thread.sleep(3000);
		//Gender - select static dropdown
		WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Thread.sleep(2000);
		Select gender = new Select(genderDropdown);
		gender.getFirstSelectedOption().click();
		
		driver.findElement(By.id("inlineRadio1")).click();
		//validate radio button is selected
		Assert.assertTrue(driver.findElement(By.id("inlineRadio1")).isEnabled());
		
		Thread.sleep(2000);
		//date of brith
		driver.findElement(By.cssSelector("input[name='bday']")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("03/09/2004");
		Thread.sleep(2000);
		driver.findElement(By.className("btn-success")).click();
		WebElement  mesages = driver.findElement(By.className("alert-success"));
		String msg1 = mesages.findElement(By.tagName("Strong")).getText();
		String msg2 = mesages.getText();
		
		System.out.println(msg1 + " " + msg2);
		driver.close();
		driver.quit();
		
			
	}

}
