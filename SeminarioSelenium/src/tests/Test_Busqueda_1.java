package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Busqueda_1 {
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  String verificationErrorString;

	  @Test
	  public void test1() throws Exception {
		  
		driver = new FirefoxDriver();
	  	baseUrl = "http://opencart.abstracta.us";
	  	
	  	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl + "/");
	    driver.findElement(By.xpath("//div[@id='search']/input")).clear();
	    driver.findElement(By.xpath("//div[@id='search']/input")).sendKeys("iphone");
	    driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
	    
	    try {
	      assertEquals("$123.20\nEx Tax: $101.00", driver.findElement(By.xpath("//div[@id='content']/div[3]/div/div/div[2]/p[2]")).getText());
	    } catch (Error e) {
	      verificationErrors.append("El precio no es el esperado");
	    }
	    
	    assertEquals("iPhone", driver.findElement(By.xpath("//div[@id='content']/div[3]/div/div/div[2]/h4/a")).getText());
	    driver.quit();
	    verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
  }
