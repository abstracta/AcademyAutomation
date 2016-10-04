package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage2 extends BasePage {

	public SearchResult2 clickSearchButton() {
		
		WebElement btnSearch = driver.findElement(By.xpath("//div[@id='search']//button[@class='btn btn-default btn-lg' and @type='button']"));
		btnSearch.click();
		return new SearchResult2(driver);
	}

	public void searchProduct(String search) {
		WebElement inpSearch = driver.findElement(By.xpath("//input[@name='search']"));
		inpSearch.sendKeys(search);
	}

	@Override
	public By getPageLoadedLocator() {
		return By.id("slideshow0");
	}

	public HomePage2(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException(
					"This is not the Abstracta Open Cart HomePage Page");
		}
	}

}
