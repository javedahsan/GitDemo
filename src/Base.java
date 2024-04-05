import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriverchrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chrome driver
		WebDriver driver = new ChromeDriver();
		//implicit wait for 20 seconds at global level
		// comment out below line to test only explict wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//explicit wait 
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		// define list items to order
		String [] itemNeeded = {"Cucumber","Brocolli","Beetroot","Carrot"};
//		Thread.sleep(3000);
		int j=0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver, itemNeeded);
		
		// select cart button
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		Thread.sleep(3000);
		// select to proceed
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		//Apply promo and apply
		//driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		// apply promo
		driver.findElement(By.className("promoBtn")).click();
		 
		// explicit wait time
		//WebDriverWait w =new WebDriverWait(driver,5); has absoluted
		
//		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		//capature promo message
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		//Code applied ..!
		//place a order
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
		
		driver.close();
		driver.quit();
		
		
		
		
		
	};
	
	public static void addItems(WebDriver driver, String[] itemNeeded) throws InterruptedException
	{
		int j=0;
		
		List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
				
		for (int i=0; i<products.size();i++) {
//			System.out.println("i " + i);
			String [] name=products.get(i).getText().split("-");
			String formatedName = name[0].trim();
		    // format name to get actual vegetable name.
			// covert Array into Array list for easy search- array takes less memory
			
			List itemNeededList = Arrays.asList(itemNeeded);
//			System.out.println("itemlist " + itemNeededList);
			// check name you extracted is present in the Arraylist or not
			
			if (itemNeededList.contains(formatedName)) {
				j++;
				
				// add qty
				driver.findElements(By.xpath("//a[@class='increment']")).get(i).click();
				Thread.sleep(2000);
			// add to cart
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				
				
				//driver.findElements(By.xpath("//a[class='increment']")).get(i).click();
				
				if(j==itemNeeded.length)
				{
					break;
				}
			}
			Thread.sleep(2000);
		}
	}

}
