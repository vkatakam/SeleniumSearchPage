package com.qa.web.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.web.pages.GoogleSearchPage;

public class SearchEngineTest {

	// =======================================================
	// INSTANTIATE PAGES TO BE TESTED
	// =======================================================
	private WebDriver driver;
	private GoogleSearchPage googleSearchPage;

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
		googleSearchPage = new GoogleSearchPage(driver);
	}

	@Test
	public void testSearchEngine() throws InterruptedException {
		String searchTerm = "Java";
		String expectedResult = "Java";
		googleSearchPage.open();
		googleSearchPage.search(searchTerm);
		String actualResult = googleSearchPage.getFirstResult();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterMethod
	public void tearDown() {
		// Clean up after the test
		driver.quit();
	}
}
