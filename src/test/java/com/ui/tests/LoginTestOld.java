/*package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOld {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); // Launch Chrome browser

		BrowserUtility browserUtilities = new BrowserUtility(wd);
		browserUtilities.goToWebsite("https://automationpractice.techwithjatin.com/");

		browserUtilities.maximizeWindow();

		By signinLinkLocator = By.xpath("//a[contains(text(),\"Sign in\")]");
		browserUtilities.clickOn(signinLinkLocator);

		By emailTextBoxLocator = By.id("email");
		browserUtilities.enterText(emailTextBoxLocator, "fisewar445@pumpoly.com");

		By passwordTextBoxLocator = By.id("passwd");
		browserUtilities.enterText(passwordTextBoxLocator, "divya2019");

		By submitButtonLocator = By.id("SubmitLogin");
		browserUtilities.clickOn(submitButtonLocator);
	}

} */
