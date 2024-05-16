package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class initializeDriver {
	
	   static WebDriver driver;

	    public WebDriver initializeDriver(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	        	WebDriverManager.chromedriver().setup();
	        	
	    		driver = new ChromeDriver();
	    		
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            
	            FirefoxOptions options = new FirefoxOptions();
	            driver = new FirefoxDriver(options);
	        }else if (browser.equalsIgnoreCase("edge")) {
	          
	            driver = new EdgeDriver();
	        }
	        else if (browser.equalsIgnoreCase("headless")) {
	            WebDriverManager.chromedriver().setup();
	            ChromeOptions chromeOptions = new ChromeOptions();
	            // Adding headless option directly for Chrome
	            chromeOptions.addArguments("--headless"); // Runs Chrome in headless mode.
	            chromeOptions.addArguments("--disable-gpu"); // Applicable for Windows only.
	            chromeOptions.addArguments("--window-size=1920,1080");
	            driver = new ChromeDriver(chromeOptions);
	        }

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        return driver;
	    }


	


}
