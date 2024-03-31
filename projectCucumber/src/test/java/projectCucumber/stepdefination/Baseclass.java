package projectCucumber.stepdefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Baseclass {
	 
	public Properties configProp;
	public static Logger logger;
	public WebDriver driver;
	
	 
	 
	 public static String randomstring() {
		 String generateString1 = RandomStringUtils.randomAlphabetic(5);
		return generateString1;
		 
	 }
	 
	
	    
	 

}
