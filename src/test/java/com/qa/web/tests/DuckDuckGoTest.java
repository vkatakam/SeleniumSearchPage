package com.qa.web.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.web.pages.DuckDuckGoPage;

public class DuckDuckGoTest {

	// =======================================================
	// INSTANTIATE PAGES TO BE TESTED
	// =======================================================
	private WebDriver driver;
	private DuckDuckGoPage duckDuckGoPage;

	/*
	 * public SearchEngineTest() {
	 * loadTestdata("src/test/resources/GoogleSearchTestData.xlsx"); }
	 */
	
	@BeforeMethod
	public void setUp() {
		// Set up WebDriver for chrome
		String projectPath = System.getProperty("user.dir");
		String googleChromePath = "\\src\\test\\resources\\selenium_standalone_binaries\\windows\\googlechrome\\64bit\\chromedriver.exe";
		System.out.println(projectPath + googleChromePath);
		String chromeDriver = projectPath + googleChromePath;
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		duckDuckGoPage = new DuckDuckGoPage(driver);
	}

	@Test
	public void testSearchEngine() throws InterruptedException {
		String searchTerm = "Java";
		String expectedResult = "Java | Oracle";
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		duckDuckGoPage.open();
		//Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		duckDuckGoPage.search(searchTerm);
		String actualResult = duckDuckGoPage.getFirstResult();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterMethod
	public void tearDown() {
		// Clean up after the test
		driver.quit();
	}
}
