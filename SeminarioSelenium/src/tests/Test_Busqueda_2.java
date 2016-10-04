package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.GetProperties;
/**
 * Web Elements
 * CSV Files
 * @author aalvarez
 */
public class Test_Busqueda_2 {
	  private WebDriver driver;
	  private String inpSearch = "//div[@id='search']/input";
	  private String btnSearch = "//div[@id='search']/span/button";
	  private String lblPrice = "//div[@id='content']/div[3]/div/div/div[2]/p[2]";
	  private String lblProductName = "//div[@id='content']/div[3]/div/div/div[2]/h4/a";
	  private StringBuffer verificationErrors = new StringBuffer();
	  String verificationErrorString;
	  private static GetProperties properties = new GetProperties();
	  String openCartUrl = properties.getString("BASE_URL");

	  @Test
	  public void test1() throws Exception {
		  
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get(openCartUrl);
	    
	    WebElement inputSearch = driver.findElement(By.xpath(inpSearch));
	    inputSearch.clear();
	    inputSearch.sendKeys("iPhone");
	    WebElement searchButton = driver.findElement(By.xpath(btnSearch));
	    searchButton.click();
	    
	    try {
	    	WebElement labelPrice = driver.findElement(By.xpath(lblPrice));
	      assertTrue(labelPrice.getText().contains("123"));
	    } catch (Error e) {
	      verificationErrors.append("El precio no es el esperado");
	    }
	    
	    WebElement labelProductName = driver.findElement(By.xpath(lblProductName));
	    assertEquals("iPhone", labelProductName.getText());
	    driver.quit();
	    verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
  }
