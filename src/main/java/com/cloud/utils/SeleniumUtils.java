package com.cloud.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import com.cloud.models.*;
import com.cloud.exceptions.TestException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class SeleniumUtils {

	/****************************************************************************************************************************
	 * Function Name : isDisplayed(WebDriver driver, By element, long timeout) Description : This method is used to
	 * delete the actual result and step status info after updating into test
	 * rail
	 * 
	 * @param columnToDelete
	 *            : column name to delete
	 * @param spreadsheet
	 *            : test rail excel sheet
	 ****************************************************************************************************************************/
	public static boolean isDisplayed(WebDriver driver, By element, long timeout) {
		try {
			return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
		} catch (TimeoutException e) {
			return false; // element not displayed
		}
	}

	
	public static boolean isDisplayed(WebDriver driver, WebElement element, long timeout) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		try {

			System.out.println("time in - " + sdf.format(new Date()) + ". Displaying " + element.toString());
/*			FluentWait<WebDriver> fluent=new FluentWait<WebDriver>(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(10,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			
			 WebElement findelement=fluent.until(new Function<WebDriver,WebElement>(){
	
				public WebElement apply(WebDriver driver)
				{
					return element;
		
				}
			});*/

			return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		} finally {
			System.out.println("time out - " + sdf.format(new Date()));
		}
	}

	
	public static boolean isEnabled(WebDriver driver, WebElement element, long timeout) {
		try {
			return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element)).isEnabled();
		} catch (TimeoutException e) {
			return false; // element not displayed
		}
	}

	
	public static boolean isFoundAndEnabled(WebDriver driver, WebElement element, long timeout) {
		try {
			return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
		} catch (TimeoutException e) {
			return false; // element not displayed
		}
	}

	public static boolean isNotPresent(WebDriver driver, By element, long timeout) {
		try {
			return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(element)));
		} catch (TimeoutException e) {
			return false; // element not found
		}
	}

	public static boolean isPresent(WebDriver driver, By element, long timeout) {
		try {
			return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed();
		} catch (TimeoutException e) {
			return false; // element not found
		}
	}

	public static boolean waitForLoading(WebDriver driver, By locator, long timeout) {
		try {
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return true;
		} catch (TimeoutException e) {
			return false; // element not found
		}
	}

	public static WebElement findElement(WebDriver driver, WebElement element, long timeout) {
		return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement findElementXpath(WebDriver driver, String xpath, long timeout) {
		return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public static List<WebElement> findElementsXpath(WebDriver driver, String xpath, long timeout) {
		return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	public static List<WebElement> getElements(WebDriver driver, WebElement element, String xpathExpression,
			long timeout) {
		if (findElement(driver, element, timeout) != null)
			return element.findElements(By.xpath(xpathExpression));
		else
			return null;
	}

	public static WebElement getElement(WebDriver driver, WebElement element, String xpathExpression, long timeout) {
		if (findElement(driver, element, timeout) != null)
			return element.findElement(By.xpath(xpathExpression));
		else
			return null;
	}

	public static WebElement getElement(WebDriver driver, WebElement element, long timeout) {
		try {
			return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			return null; // element not found
		}
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void click(WebElement element, WebDriver driver) {
		// focusElement(element, driver);
		element.click();
	}

	public static void scroll(WebDriver driver, int x, int y) {
		try {
			System.out.println("Scrolling for." + x + "," + y);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(" + x + "," + y + ")", "");
			//je.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			SeleniumUtils.delay(2000);
		} catch (Exception e) {
			System.out.println("Scroll is not done successfully.");
		}
	}

	public static String read(WebElement element) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		System.out.println("time in - " + sdf.format(new Date()) + ". getting text for " + element.toString());
		String text = null;
		text = element.getText();
		System.out.println("Text found for element " + element.toString() + " is - " + text);
		if (text == null) {
			text = element.getAttribute("text");
		}
		System.out.println("time out - " + sdf.format(new Date()));
		return text;
	}

	public static String readAttribute(WebElement element, String attributeName) throws TestException {
		String attribValue = element.getAttribute(attributeName);
		if (attribValue == null) {
			throw new TestException("No value returned for the attribute or css property " + attributeName);
		}
		return attribValue;
	}

	public static void sendKeys(WebElement element, String input) {
		element.sendKeys(input);
	}

	public static void sendKeys(WebDriver driver, String strParent, String strChild, String arr) {
		System.out.println("First Name Layout is displayed.");
		List<WebElement> parent = driver.findElements(By.className(strParent));
		System.out.println("Size of parent element is " + parent.size());
		for (int i = 0; i < parent.size(); i++) {
			parent.get(i).findElement(By.className(strChild)).sendKeys(arr);
		}

	}


	public static void submit(WebElement element) {
		element.submit();
	}

	public static void delay(long msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
		}
	}


	public static void setTxtbox(WebDriver driver, WebElement elementInput, String input) {
		click(elementInput, driver);
		elementInput.clear();
		if (!(input == null || input.isEmpty())) {
			elementInput.sendKeys(input);
		}
	}


	private static String mainWindowsHandle; // Stores current window handle
	
	 public static boolean swithToWindow(WebDriver driver,String title)
	 {
		  mainWindowsHandle = driver.getWindowHandle();
		  Set<String> handles = driver.getWindowHandles(); // Gets all the available windows
		  for(String handle : handles)
		  {
			  
			    driver.switchTo().window(handle); // switching back to each window in loop
			   // if(driver.getTitle().equals(title)) // Compare title and if title matches stop loop and return true
			    if(driver.getTitle().contains(title)) // Compare title and if title matches stop loop and return true
			 	   return true; // We switched to window, so stop the loop and come out of funcation with positive response
		  }
		  driver.switchTo().window(mainWindowsHandle); // Switch back to original window handle
		  return false; // Return false as failed to find window with given title.
	 }
}
