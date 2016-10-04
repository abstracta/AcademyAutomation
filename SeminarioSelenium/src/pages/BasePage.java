package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WebDriverUtils;

public abstract class BasePage {

	public static WebDriver driver;

	/**
	 * Instantiates a new base page.
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public final boolean isLoaded() {
		return WebDriverUtils.isElementPresent(BasePage.driver,
				this.getPageLoadedLocator());
	}

	public abstract By getPageLoadedLocator();
}
