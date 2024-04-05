package Tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// validate SSL certificate
		// use Chromeoptions
		// in firefox - has similar option - FirefoxOptions 
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		// FirefoxOptiosn options = new FirefoxOptions()
		// options.setAcceptInsecureCerts(true);
		
		// EdgeOptions options = new EdgeOptions();
		// options.setAcceptInsecureCerts(true); 
		
		// other options eg. extensions if we want extension chropath to Browser
		
		//options.addExtensions("add chropath file path and exe");
		
		// set proxy -- see more capabilities
		// https://chromedriver.chromium.org/capabilities
		
		Proxy proxy = new Proxy();
		// Ask security team to provide - ipaddress and port number
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		
		//blocking popups
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches",
//		Arrays.asList("disable-popup-blocking"));
		
		
		// set download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
