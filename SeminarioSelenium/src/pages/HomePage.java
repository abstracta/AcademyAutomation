package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	// Elements Ids
	@FindBy(how = How.XPATH, using = "//div[@id='search']//button[@class='btn btn-default btn-lg' and @type='button']")
	private WebElement btnSearch;

	@FindBy(how = How.XPATH, using = "//input[@name='search']")
	private WebElement inpSearch;

	// Methods

	public SearchResult clickSearchButton() {
		btnSearch.click();
		return PageFactory.initElements(driver, SearchResult.class);
	}

	public void searchProduct(String search) {
		inpSearch.sendKeys(search);
	}

	// Page locator

	@Override
	public By getPageLoadedLocator() {
		return By.id("slideshow0");
	}

	public HomePage(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException(
					"This is not the Abstracta Open Cart HomePage Page");
		}
	}

}
