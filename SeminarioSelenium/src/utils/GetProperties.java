package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Reporter;

public class GetProperties {
	
	
	    // The property object
	    private Properties prop = new Properties();

	    /**
	     * Default constructor
	     */
	    public GetProperties() {

	        InputStream in = getClass().getResourceAsStream("/config.properties");
	        try {
	            prop.load(in);
	        } catch (FileNotFoundException e) {
	            Reporter.log("The property file was not found");
	        } catch (IOException e) {
	            Reporter.log("Can not read property file");
	        }
	    }

	    /**
	     * Get String property
	     *
	     * @param propertyName
	     *            property name
	     * @return String value
	     */
	    public String getString(String propertyName) {
	        return prop.getProperty(propertyName);
	    }

	    /**
	     * Get Integer property
	     *
	     * @param propertyName
	     *            property name
	     * @return Integer value
	     */
	    public Integer getInteger(String propertyName) {
	        return Integer.valueOf(prop.getProperty(propertyName));
	    }

	    /**
	     * Get Double property
	     *
	     * @param propertyName
	     *            property name
	     * @return Double value
	     */
	    public Double getDouble(String propertyName) {
	        return Double.valueOf(prop.getProperty(propertyName));
	    }

}
