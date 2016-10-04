package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.GetProperties;

/**
 * Better Locators Parameterize Junit better approach
 * //a[contains(text(),'iMac')]/ancestor::div[@class='product-thumb']//span[contains(text(),'Add to Cart')] 
 * @author aalvarez
 */
@RunWith(JUnitParamsRunner.class)
public class Test_busqueda_3 {

	private WebDriver driver;
	private static GetProperties properties = new GetProperties();

	// Elements
	private String inpSearch = "//input[@name='search']";
	private String btnSearch = "//div[@id='search']//button[@class='btn btn-default btn-lg' and @type='button']";
	private String lblPrice = "//*[@class='price']";
	private String lblProductName = "//div[@class='caption']/h4/a";
	private StringBuffer verificationErrors = new StringBuffer();
	private String search;
	private String searchPrice;
	private String verificationErrorString;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(properties.getString("BASE_URL"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	@FileParameters("src/products.csv")
	public void test1(String _search, String _searchPrice) throws Exception {
		this.search = _search;
		this.searchPrice = _searchPrice;
		WebElement inputSearch = driver.findElement(By.xpath(inpSearch));
		inputSearch.clear();
		inputSearch.sendKeys(search);
		WebElement searchButton = driver.findElement(By.xpath(btnSearch));
		searchButton.click();

		try {
			WebElement labelPrice = driver.findElement(By.xpath(lblPrice));
			assertTrue(labelPrice.getText().contains(searchPrice));
		} catch (Error e) {
			verificationErrors.append("El precio no es el esperado: "
					+ e.toString());
		}

		WebElement labelProductName = driver.findElement(By
				.xpath(lblProductName));
		assertEquals(search, labelProductName.getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
