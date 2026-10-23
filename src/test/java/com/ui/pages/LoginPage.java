package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXTBOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver); // To call the parent class constructor 
	}

	public MyAccountPage doLoginWith(String emailAddress, String password) { //Page functions cannot return void type -rule in page object design pattern
		enterText(EMAIL_TEXTBOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		
		MyAccountPage myaccountPage = new MyAccountPage(getDriver());
		return myaccountPage;
	}

}
