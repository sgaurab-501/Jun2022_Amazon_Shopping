package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class LoginPage {

	private WebDriver driver;
	
	// 1. private By locators: OR
		
	private By menuList = By.xpath("//div[@id='nav-tools']/a[contains(@href,'signin')]");
   private By signInLink = By.partialLinkText("Sign In");
   private By emailOrPhone = By.id("ap_email");
  private By continueButton = By.xpath("//div[@class='a-section']/span[@id='continue']");   
private By passInput = By.xpath("//div[@class='a-section a-spacing-large']/input[@id='ap_password']");
private By signInButton = By.xpath("//div[@class='a-section']/span/span/span[@id='auth-signin-button-announce']");
private By forgotPassLink = By.xpath("//div[@class='a-column a-span7 a-text-right a-span-last']/a[contains(text(),'Forgot')]");
private By createAccLink = By.id("createAccountSubmit");



	// 2. public page class constructor

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}

	// 3. public page actions
	// using the private data members - encapsulation

	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Login page title: "+title);
	return title;

	}

	public String getLoginPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Login page url is: "+url);
	return url;
	}

	public boolean isForgotPwdLinkExists() {
		return driver.findElement(forgotPassLink).isDisplayed();
	}

	public boolean isCreateAccLinkExists() {
		
		return driver.findElement(createAccLink).isDisplayed();
		
	}

	public AccountPage doLogin(String uname, String pwd) throws Exception {

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(menuList)).build().perform();
		
		driver.findElement(signInLink).click();
		driver.findElement(emailOrPhone).sendKeys();
		driver.findElement(continueButton).click();
		driver.findElement(passInput).sendKeys(null);
		driver.findElement(signInButton).click();
		
		waitForTime(3000);
		
		
	    waitForTime(2000);
	return new AccountPage(driver);
			
	}

	public void waitForTime(int milliSec) throws Exception {
		
		Thread.sleep(2000);
			
	}	
	
	
}
