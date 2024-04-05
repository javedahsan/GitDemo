import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		// dynamic dropdwon
		System.setProperty("webdriverchrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("*//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(3000);
		
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));
		//Thread.sleep(2000);
		// destination
		
		Thread.sleep(3000);
		
//		driver.findElement(By.xpath("//[@id='ctl00_mainContent_ddl_destinationStation1_CTXTaction'])).click();
//		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		// use this parent child relationship
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();
//		
		Thread.sleep(3000);
//		WebElement ele=driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
//		
//		
//		Select sel=new Select(ele);
//		sel.selectByValue("2");

	
	}

}
