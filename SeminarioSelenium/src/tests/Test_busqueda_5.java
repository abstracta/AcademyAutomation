package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import pages.SearchResult;
import utils.GetProperties;
/**
 * Using PageFactory
 * @author aalvarez
 *
 */
@RunWith(JUnitParamsRunner.class)
public class Test_busqueda_5 {

	private WebDriver driver;
	private static GetProperties properties = new GetProperties();

	// Elements

	private StringBuffer verificationErrors = new StringBuffer();
	private String search;
	private String searchPrice;

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

		HomePage hompePage = PageFactory.initElements(driver, HomePage.class);
		hompePage.searchProduct(search);
		SearchResult searchResult = hompePage.clickSearchButton();
		//Assert Product Name
		assertEquals(searchResult.getProductNameLabel(),_search );
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
