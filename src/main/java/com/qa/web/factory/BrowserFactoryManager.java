package com.qa.web.factory;

import org.openqa.selenium.WebDriver;

/**
 * @author Venkat Katakam 
 * BrowserFactoryManager - Introduced this class to
 * ensure webdriver doesn't overlap in a parallel execution ThreadLocal
 * provides thread-local variables to ensure thread safe executions.
 *         
 */
public class BrowserFactoryManager {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

}
