package com.qa.web.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver webDriver;
	protected String environment;
	protected String testCaseName;
	private String browser;

	public BasePage() {
		super();
	}

	/**
	 * Initialize the parameters for the page
	 * 
	 * @param webDriver
	 * @param environment
	 * @param testCaseName
	 */
	public void setPage(WebDriver driver, String environment, String browser, String testCaseName) {
		this.webDriver = driver;
		this.environment = environment;
		this.browser = browser;
		this.testCaseName = testCaseName;
	}

	/**
	 * ListElement Method is framework provided method It is used to return the
	 * valid element in the list *
	 * 
	 * @param lstElmt
	 * @return list element of type WebElement
	 */
	public WebElement listElement(List<WebElement> lstElmt) {
		for (WebElement lctr : lstElmt) {
			try {
				if (lctr.isDisplayed())
					return lctr;
			} catch (Exception e) {
				continue;
			}
		}
		return null;
	}

	/**
	 * Get Browser name *
	 * 
	 * @return browser name as string
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * Get environment name *
	 * 
	 * @return environment name as string
	 */
	public String getEnvironment() {
		return environment;
	}

}