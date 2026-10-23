package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		HomePage homePage = new HomePage(wd);
		String username = homePage.goToLoginPage().doLoginWith("fisewar445@pumpoly.com", "divya2019").getUserName();
		System.out.println(username);

	}

}
