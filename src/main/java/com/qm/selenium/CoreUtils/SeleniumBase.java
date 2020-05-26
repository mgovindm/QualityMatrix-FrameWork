package com.qm.selenium.CoreUtils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qm.SupportedUtils.Constants;
import com.qm.SupportedUtils.Reporter;
import com.qm.SupportedUtils.lib;

public class SeleniumBase extends Reporter implements Browser, Element {

	public RemoteWebDriver driver;
	public WebDriverWait wait;

	public RemoteWebDriver startApp(String browser, boolean bRemote) {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.navigate().to(Constants.TESTING_APPURL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return driver;

	}

	@Override
	public void click(WebElement ele) {
		String text = "";
		try {
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The Element " + text + " clicked", "pass", true);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + text + " could not be clicked", "fail");
			throw new RuntimeException();
		}
	}

	

	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The Data :" + data + " entered Successfully", "pass",true);
		} catch (ElementNotInteractableException e) {
			reportStep("The Element " + ele + " is not Interactable", "fail");
			throw new RuntimeException();
		}

	}

	@Override
	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);
		reportStep("User switched to Frame", "pass",true);

	}

	@Override
	public void defaultContent() {
		driver.switchTo().defaultContent();

	}

	
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	@Override
	public void close() {
		driver.close();

	}

	@Override
	public void quit() {
		driver.quit();

	}

	public void clickByAction(WebElement mouseEle, WebElement actionEle, String field) throws InterruptedException {
		try {
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(mouseEle));
			Actions builder = new Actions(driver);
			builder.moveToElement(mouseEle).build().perform();
			waitForElementLoad(2000);
			builder.moveToElement(actionEle).click().build().perform();
			waitForElementLoad(2000);
			reportStep("The Element " + field + " clicked", "pass", false);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + field + " Not clicked", "fail");
			throw new RuntimeException();
		}
	}

	public void clickBySingleAction(WebElement mouseEle, String field) {
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(mouseEle));
			Actions builder = new Actions(driver);
			builder.moveToElement(mouseEle).click().build().perform();
			reportStep("The Element " + field + " clicked", "pass", false);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + field + " Not clicked", "fail");
			throw new RuntimeException();
		}
	}

	public void click(WebElement ele, String Field) {
		String text = "";
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The Element " + text + " clicked in " + Field + "", "pass", false);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + text + " could not be clicked", "fail");
			throw new RuntimeException();
		}
	}

	public void scrollBottom(WebDriver driver) {
		waitForElementLoad(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3500)");
	}

	public boolean waitforcomponent(WebDriver driver, WebElement eleofFirstCandidate, long lngWaitTime) {
		WebElement weElement = null;
		for (int i = 0; i <= lngWaitTime && weElement == null; i++) {
			try {
				Thread.sleep(1000);
				weElement = driver.findElement((By) eleofFirstCandidate);
			} catch (Exception e) {
				weElement = null;
			}
		}
		if (weElement == null)
			return false;
		else
			return true;
	}


	public static String separateDigitsAndAlphabets(String str) {
		StringBuffer alpha = new StringBuffer(), num = new StringBuffer(), special = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)))
				num.append(str.charAt(i));
			else if (Character.isAlphabetic(str.charAt(i)))
				alpha.append(str.charAt(i));
			else
				special.append(str.charAt(i));
		}
		return num.toString();
	}

	public void waitForElementLoad(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
