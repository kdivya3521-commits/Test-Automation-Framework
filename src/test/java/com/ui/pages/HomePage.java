package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.ENV.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	static final By SIGNIN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");
	Logger logger = LoggerUtility.getLogger(getClass());


	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		//goToWebsite(readProperty(QA,"URL")); //Using properties file
		goToWebsite(JSONUtility.readJSON(QA).getUrl()); //Using JSON Utility file
		maximizeWindow();
	}

	public HomePage(WebDriver driverLocal) {
		super(driverLocal);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		maximizeWindow();
	}

	public LoginPage goToLoginPage() { // Page Functions cannot return void type this is the thumb rule
		logger.info("Trying to Navigate to Login Page");
		clickOn(SIGNIN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
