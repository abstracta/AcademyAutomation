package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WebDriverUtils {

	/**
	 * returns true if webelement is present and returns false if not
	 * 
	 * @param driver
	 * @param byLocator
	 * @param seconds
	 * @return
	 */
	public static boolean isElementPresent(WebDriver driver, final By Locator) {
		try {
			driver.findElement(Locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
