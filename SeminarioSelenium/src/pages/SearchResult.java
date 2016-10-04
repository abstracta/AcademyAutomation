package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResult extends BasePage {

	// Elements Ids
	@FindBy(how = How.XPATH, using = "//div[@class='caption']/h4/a")
	private WebElement lblProductName;

	// Methods
	public String getProductNameLabel(){
		
		return lblProductName.getText();
	}

	// Page locator
	@Override
	public By getPageLoadedLocator() {
		return By.xpath("//h2[contains(text(),'Products meeting the search criteria')]");
	}

	public SearchResult(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException(
					"This is not the Search Result Page");
		}
	}

}
