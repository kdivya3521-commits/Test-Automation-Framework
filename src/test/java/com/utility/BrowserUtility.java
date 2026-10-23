package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // Now it is Threadsafe utiltiy class
	Logger logger = LoggerUtility.getLogger(getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching Browser for " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());

		} else {
			logger.error("Invalid Browser name.....Please select chrome or edge only");
			System.err.print("Invalid Browser name....Please select chrome or edge only");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.SAFARI) {
			driver.set(new SafariDriver());
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); // going to launch driver in headless mode
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());

			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("diable.gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}

			driver.set(new SafariDriver());
		}
	}

	public void goToWebsite(String url) {
		logger.info("Navigating to url " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the window");

		driver.get().manage().window().maximize();
	}

	public void clickOn(By Locator) {
		logger.info("finding the locator of signin link");

		WebElement signinLink = driver.get().findElement(Locator);
		logger.info("Clickin in link");

		signinLink.click();
	}

	public void enterText(By Locator, String textToEnter) {
		WebElement emailTextBox = driver.get().findElement(Locator);
		emailTextBox.sendKeys(textToEnter);
	}

	public String getVisibleText(By Locator) {
		WebElement visibleText = driver.get().findElement(Locator);
		return visibleText.getText();

	}

	public void quit() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove(); // Essential when using ThreadLocal to avoid memory leaks
		}
	}

	public String takeScreenShot(String screenshotName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = formate.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + "-" + timeStamp + screenshotName + ".png";
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}

}