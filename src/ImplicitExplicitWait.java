import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// implicit and explicit wait

		/*
		 * https://rahulshettyacademy/loginpagePractise/
		 * 
		 * login to rahulshettyacademy page rahulshettyacademy pass: learning
		 * 
		 * check User -- Then Consultant agree click_here_link
		 * 
		 * signing -- apply explicit page
		 * 
		 * wait until all items are loaded
		 * 
		 * then select all items and display 3rd page
		 */

		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chrome driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// implicit wait for 20 seconds at global level
		// comment out below line to test only explict wait
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		System.out.println(driver.getTitle());

		// login page

		loginPage(driver, w);

		// 2nd page CartItem
		System.out.println(driver.getCurrentUrl());

		// w.until(ExpectedConditions.visibilityOfElementLocated(By.className("row")));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer")));

		itemCartPage(driver, w);

		// 3rd page Checkout

		checkOutPage(driver, w);

		System.out.println("4th page");

		
		// 4th page submit
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
		   
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.xpath("//div[@class='suggestions']/ul/li/a")).isDisplayed())
					{
						return driver.findElement(By.xpath("//div[@class='suggestions']"));	
					}
				else
					{
						return null;
					}
			  }
			});
		System.out.println(driver.findElement(By.xpath("//div[@class='suggestions']/ul/li/a")).getText());
		
		driver.findElement(By.xpath("//div[@class='checkbox-primary']//input[@id=('checkbox2')]")).click();
		
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
	}

	public static void loginPage(WebDriver driver, WebDriverWait w) {

		// input credentials
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");

		// select radio button user
		driver.findElement(By.cssSelector("input[value='user']")).click();
		// Thread.sleep(3000);

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();

		// select static dropdown
		WebElement userTypes = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
		Select userType = new Select(userTypes);
		userType.selectByIndex(2);

		// terms
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
	}

	public static void itemCartPage(WebDriver driver, WebDriverWait w) {
		List<WebElement> cartItems = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		// Thread.sleep(3000);
		for (int i = 0; i < cartItems.size(); i++) {
//				String [] name=cartItems.get(i).getText().split("-");
//				String cartItem = name[0].trim();
			driver.findElements(By.cssSelector("i[class='zmdi zmdi-shopping-cart']")).get(i).click();
			System.out.println("i" + i);
		}

		// ca class="nav-link btn btn-primary"> Checkout ( 4 )heckout
		// Thread.sleep(3000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='navbarResponsive']//a")));

		driver.findElement(By.xpath("//div[@id='navbarResponsive']//a")).click();
	}

	// checkout page
	public static void checkOutPage(WebDriver driver, WebDriverWait w) {
		System.out.println(driver.getCurrentUrl());
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));
		// Thread.sleep(5000);
		WebElement tbody = driver.findElement(By.xpath("//tbody"));
		List<WebElement> childNodes = tbody.findElements(By.xpath("./child::*"));
		// iterate Child nodes
		for (WebElement i : childNodes) {
			// System.out.println(i.getText());

			if (i.getText().contains("Checkout")) {
				List<WebElement> j = i.findElements(By.tagName("button"));
				for (WebElement k : j) {
					System.out.println(k.getText());
					if (k.getText().contains("Checkout")) {
						k.click();
					}
				}
				
			}

		}
	}

}
