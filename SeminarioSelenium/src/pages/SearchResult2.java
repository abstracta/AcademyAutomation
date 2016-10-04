package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResult2 extends BasePage {

	public String getProductNameLabel(){
		WebElement lblProductName = driver.findElement(By.xpath("//div[@class='caption']/h4/a"));
		return lblProductName.getText();
	}

	public boolean isPageLoaded(){
		return driver.getTitle().contains("Search");
	}

	@Override
	public By getPageLoadedLocator() {
		return By.xpath("//h2[contains(text(),'Products meeting the search criteria')]");
	}

	public SearchResult2(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException(
					"This is not the Search Result Page");
		}
	}

}
