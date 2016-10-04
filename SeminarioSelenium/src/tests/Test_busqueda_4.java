package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
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
import pages.HomePage2;
import pages.SearchResult;
import pages.SearchResult2;
import utils.GetProperties;
/**
 * Without PageFactory
 * @author aalvarez
 */
@RunWith(JUnitParamsRunner.class)
public class Test_busqueda_4 {

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

		HomePage2 hompePage2 = new HomePage2(driver);
		hompePage2.searchProduct(search);
		SearchResult2 searchResult = hompePage2.clickSearchButton();
		assertTrue("Search Page Not Loaded", searchResult.isPageLoaded());
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
