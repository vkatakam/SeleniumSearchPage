package com.qa.web.factory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
	
/**
 * @author Venkat Katakam
 * This class is used to instantiate the browsers in runtime. Especially useful when different browsers are required for different 
 * testcases and for parallel execution. 
 */
public class BrowserFactory {		
	/**
	 * Factory method to create an instance of the browser web webDriver and pass the page url to the browser.

	 * @param browserName
	 * @param sdriver
	 * @param url
	 * @return WebDriver object
	 */
	public static WebDriver startBrowser(String browserName,String sdriver, String url)
	{
		WebDriver webDriver = null;
		if(browserName.equalsIgnoreCase("firefox")){			
			webDriver = new FirefoxDriver();			
		}else if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", sdriver);
			webDriver = new ChromeDriver();			
		}else if (browserName.equalsIgnoreCase("safari")){			
			webDriver = new SafariDriver();
		}
		webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		webDriver.manage().window().maximize();
		webDriver.get(url);
		return webDriver;
	}
}
