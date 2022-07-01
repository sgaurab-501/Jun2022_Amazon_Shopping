package com.qa.amazon.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;
	Properties prop;

		/**
		 * this method is used to initialize the driver on basis of given browser name	
		 * this method will return the webdriver
		 */
		public WebDriver init_driver(Properties prop) {

	String browserName = prop.getProperty("browser");		
			
	System.out.println("Browser name is: "+browserName);
			
	if(browserName.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();

	
	}

	else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("safari")) {
	WebDriverManager.safaridriver().setup();
	driver = new SafariDriver();
		
	}
	else {
		System.out.println("Please enter the right browser name: "+browserName);
	}

	driver.manage().deleteAllCookies();
	String url = prop.getProperty("url");

	driver.get(url);


	return driver;

		}

	/*
	 * this method is used to initialize the properties from respective config file
	 * @return this returns properties class object with the config properties	
	 */
		
		
	public Properties init_prop(WebDriver driver) {
		
//		FileInputStream ip = new FileInputStream("E:\\eclipse-workspace\\Jun2022_WordPressJourney\\src\\main\\resources\\config\\config.properties");

		prop = new Properties();
			
		try {
			try {
				FileInputStream fp = new FileInputStream("./src/main/resources/config/config.properties");
	         
			prop.load(fp);
		
			} catch (FileNotFoundException e) {
				
				
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		
		}

	return prop;
	}
	
	
}
