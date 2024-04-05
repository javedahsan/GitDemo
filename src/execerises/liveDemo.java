package execerises;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class liveDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO find item in different pages - pagination 
		
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.getTitle();

		Thread.sleep(3000);
//		1. click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
//		2. Capture all WebElements into list
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

//		3. capture text of all webelements into new original list
		List<String> originalList = rows.stream().map(s -> s.getText()).collect(Collectors.toList());
//		4. sort on original list on step 3and create new list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
//		5. compare orginal list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		System.out.println(originalList);
		System.out.println(sortedList);

//		5. retrive the price of Bean - try to find element available in subsequent pages e.g. Rice

		List <String> price;
		do {
			List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
			// Beans is available in first page where as Rice is located at 4th page
			price = elementsList.stream().filter(s -> s.getText().contains("Rice"))
					.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
//		   print all element in list
			price.forEach(a -> System.out.println(a));

//			if element is not available then price will be null --apply do while loop 
	      if (price.size()<1)
	      {
	    	  driver.findElement(By.cssSelector("[aria-label='Next']")).click();
	      }
		}while(price.size()<1);
		
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String getPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return getPrice;
	}

}
