
package com.web.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Webutils {

	WebElement locator;
	private static WebDriver driver;
    private static long POLLING_INTERVAL_LONG_MS = 20;
	private static long IMPLICITE_WAIT_S = 5;
	private static long TIMEOUT_S = 35;
	private static long EXPLICIT_WAIT_S = 20;
	Logger logger = Logger.getLogger(Webutils.class);

	public Webutils(WebDriver driver) {
		// TODO Auto-generated constructor stub

	}
	/**
	 * Method Name: isElementExist Description: to check whether element is present
	 * on page. Author: Manimaran
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean isElementExist(WebElement element) {
		boolean flag = true;
		try {

			if (element.isDisplayed()) {
				flag = true;
				logger.info(element + " is Present");

			} else {
				flag = false;
				logger.info(element + " is not present");

			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return flag;

	}

	/**
	 * Method Name: isEnabled Author: Manimaran Return type: none Parameters: element
	 * Description: to check whether element is enabled.
	 */

	public boolean isEnabled(WebElement element) {
		boolean flag = true;
		try {
			if (element.isEnabled()) {
				flag = true;
				logger.info(element + " is Present");
			} else {
				flag = false;
				logger.info(element + " is not present");
			}

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void navigateUrl(String url) {
		driver.get(url);
	}

	/********************************************************
	 * Method Name: clickElement Author: Manimaran Return type: none Parameters: element
	 * Description: to click the element.
	 * 
	 ********************************************************/

	public void clickElement(WebElement element) {
		try {
			element.click();

		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (NullPointerException e1) {
			e1.printStackTrace();

		}
	}

	/********************************************************
	 * Method Name: selectFromDropdown_Using_index Author: Manimaran Return type: none
	 * Parameters: element, index Description: to select value from dropdown using
	 * index.
	 * 
	 ********************************************************/
	public void selectFromDropdown_Using_index(WebElement element, int index) {
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/********************************************************
	 * Method Name: selectFromDropdown_Using_Value Author: Manimaran Return type: none
	 * Parameters: element, value Description: to select value from dropdown using
	 * Value.
	 * 
	 ********************************************************/
	public void selectFromDropdown_Using_Value(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/********************************************************
	 * Method Name: selectFromDropdown_Using_Text Author: Manimaran Return type: none
	 * Parameters: element, text Description: to select value from dropdown using
	 * Visible Text.
	 * 
	 ********************************************************/
	public void selectFromDropdown_Using_Text(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/********************************************************
	 * Method Name: waitForMilliSeconds Author: Manimaran Return type: none Parameters:
	 * number Description: wait for control to load for specified amount of time.
	 * 
	 ********************************************************/
	public void waitForMilliSeconds(long number) {

		try {
			Thread.sleep(number);
		} catch (InterruptedException ie) {

		}

	}

	/**
	 * Author: Manimaran This method enters the given text in the text box
	 * 
	 * @param element
	 *            - text box
	 * @param text
	 *            - Text to be entered Return type: none
	 */
	public void enterTextinTextbox(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * * Method Name: uploadFile Author: Manimaran Return type: none Parameters:
	 * uploadfileelement, filepath, buttonelement Description: to upload file.
	 * 
	 * @param uploadfileelement
	 * @param filepath
	 * @param buttonelement
	 */
	public void uploadFile(WebElement uploadfileelement, String filepath, By buttonelement) {

		try {
			// enter the file path onto the file-selection input field
			uploadfileelement.sendKeys(filepath);
			// click the "Upload" button
			driver.findElement(buttonelement).click();
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Method Name: initiateBrowser Author: Manimaran Return type: none Parameters: none
	 * Description: to launch the browser.
	 * 
	 * @param browser
	 */
	public static void initiateBrowser(String browser) {
		String os = System.getProperty("os.name").toLowerCase();
		String current_dir = System.getProperty("user.dir");
		System.out.println(os);
		System.out.println(current_dir);
		switch (browser) {
		case "ie":
			System.setProperty("webdriver.ie.driver", current_dir + "/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			if (os.contains("linux")) {
				System.setProperty("webdriver.chrome.driver", current_dir + "/drivers/linuxdrivers/chromedriver");
				DesiredCapabilities caps = DesiredCapabilities.chrome();
		        LoggingPreferences logPrefs = new LoggingPreferences();
		        logPrefs.enable(LogType.BROWSER, Level.ALL);
		        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		        
				options.setBinary("/usr/bin/google-chrome");
				options.addArguments("--headless");
			} else if (os.contains("windows")) {
				System.setProperty("webdriver.chrome.driver", current_dir + "/drivers/chromedriver.exe");
				DesiredCapabilities caps = DesiredCapabilities.chrome();
		        LoggingPreferences logPrefs = new LoggingPreferences();
		        logPrefs.enable(LogType.BROWSER, Level.ALL);
		        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			}
			options.addArguments("test-type");
			options.addArguments("disable-popup-blocking");
			driver = new ChromeDriver(options);
			
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	/**
	 * Method Name: getElement Author: Manimaran Return type: none Parameters: element
	 * Description: to click the element.
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement ele = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_S);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			ele = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (TimeoutException e1) {
			e1.printStackTrace();
		}
		return ele;

	}

	/**
	 * This method returns the list of WebElement
	 * 
	 * @param locator
	 *            - By Locators
	 * @return - List <WebElement>
	 */
	public List<WebElement> getElements(By locator) {
		List<WebElement> ele = new ArrayList<WebElement>();
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_S);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			ele = driver.findElements(locator);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ele;
	}

	/**
	 * Getter method for Driver object
	 * 
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * This method dynamically generates the XPath
	 * 
	 * @param xpath
	 *            - XPath variable
	 * @param value
	 *            - Substitute Value
	 * @return - Complete XPath String
	 */
	public String getXPath(String xpath, String value) {
		return String.format(xpath, value);
	}
	
	/**
	 * This method dynamically generates the XPath
	 * 
	 * @param xpath
	 *            - XPath variable
	 * @param value
	 *            - Substitute Value
	 * @return - Complete XPath Integer
	 */
	public String getXPath(String xpath, int value) {
		return String.format(xpath, value);
	}


	@SuppressWarnings("deprecation")
	protected void explicitlyWaitUntilVisible(WebElement element, long timeout) {
		try {
			new FluentWait<>(getDriver()).withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(POLLING_INTERVAL_LONG_MS, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));
		} finally {
			getDriver().manage().timeouts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
		}
	}

	@SuppressWarnings("deprecation")
	protected void explicitlyWaitUntilclickable(WebElement element, long timeout) {
		try {
			new FluentWait<>(getDriver()).withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(POLLING_INTERVAL_LONG_MS, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(element));
		} finally {
			getDriver().manage().timeouts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
		}
	}

	/**
	 * Author : ManimaranThis THis method waits for the page to load
	 * 
	 * @param timeout
	 *            - time to wait
	 */
	public void waitForPageToLoad(long timeout) {
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < timeout * 1000) {
			boolean pageLoaded = (String) getExecutor().executeScript("return document.readyState") == "complete";
			if (pageLoaded) {
				return;
			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * Author : ManimaranThis THis method waits till the given Object disappears.
	 * 
	 * @param locator
	 *            - By Locator
	 */
	public void waitTillObjectDisappears(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_S);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Author : ManimaranThis THis method waits till the given Object disappears.
	 * 
	 * @param locator
	 *            - By Locator
	 */
	public void waitTillObjectAppears(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_S);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Author : ManimaranThis method returns the JavaScript executor object
	 * 
	 * @return
	 */
	protected JavascriptExecutor getExecutor() {
		return ((JavascriptExecutor) driver);
	}

	/**
	 * Author : ManimaranTHis method clicks on an element using Java script.
	 * 
	 * @param element
	 */
	public void clickJS(WebElement element) {
		getExecutor().executeScript("arguments[0].click();", element);
	}

	/**
	 * This method hovers over the given WebElement
	 * 
	 * @param element
	 *            - WebElement
	 */
	public void hoverOver(WebElement element) {
		Actions action = new Actions(getDriver());
		action.moveToElement(element).build().perform();
	}

	/**
	 * Author : ManimaranThis method switches to particular window by title
	 * 
	 * @param title
	 *            - Browser Title
	 */
	public void switchToWindow(String title) {
		Set<String> windowHandles = getDriver().getWindowHandles();
		for (String str : windowHandles) {
			getDriver().switchTo().window(str);
			System.out.println("window title: " + getDriver().getTitle());
			if (getDriver().getTitle().contains(title))
				break;
		}
	}

	/**
	 * Author : ManimaranSwitches to default window
	 */
	public void switchToDefaultWindow() {

	}

	/**
	 * Author : ManimaranThis method closes current browser
	 */
	public void closeWindow() {
		getDriver().close();

	}

	/**
	 * Author : ManimaranThis method closes all browsers
	 */
	public void quitBrowsers() {

		getDriver().quit();
	}

	/**
	 * Author : ManimaranThis method scrolls and focuses on the WebElement
	 * 
	 * @param element
	 *            - WebElement
	 */
	public void centerViewVerticallyOnElement(WebElement element) {
		int elementPositionInView = ((RemoteWebElement) element).getCoordinates().inViewPort().getY();
		int viewPortHeight = getDriver().manage().window().getSize().getHeight();
		int posDiff = elementPositionInView - viewPortHeight / 2;
		getExecutor().executeScript(String.format("window.scrollBy(0, %s)", posDiff));
	}

	/**
	 * Author : ManimaranThis method scrolls and focuses on the WebElement
	 * 
	 * @param element
	 *            - By Locator
	 */
	public void centerViewVerticallyOnElement(By locator) {
		WebElement element = null;
		try {
			element = getDriver().findElement(locator);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		centerViewVerticallyOnElement(element);
	}

	// Following methods were developed on Date : 02/28/2019
	/**
	 * Author : ManimaranThis method accepts the Alert/Popup
	 */
	public void acceptAlert() {
		Alert popUp = null;
		try {
			popUp = getDriver().switchTo().alert();
			popUp.accept();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Author : ManimaranThis method dismisses the Alert/Popup
	 */
	public void dismissAlert() {
		Alert popUp = null;
		try {
			popUp = getDriver().switchTo().alert();
			popUp.dismiss();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Author : ManimaranThis method returns the Alert/Popup text
	 */
	public String getAlertText() {
		Alert popUp = null;
		try {
			popUp = getDriver().switchTo().alert();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return popUp.getText().trim();
	}

	/**
	 * Author : ManimaranThis method double clicks over the given WebElement
	 * 
	 * @param element
	 *            - WebElement
	 */
	public void doubleClick(WebElement element) {
		Actions action = new Actions(getDriver());
		action.doubleClick(element);
	}

	/**
	 * Author : ManimaranThis method returns the current Page Title
	 * 
	 * @return - Page Title
	 */
	public String getTitle() {
		return getDriver().getTitle().trim();
	}

	/**
	 * Author : ManimaranThis method switches to last window
	 * 
	 * @param title
	 *            - Browser Title
	 */
	public void switchToLastWindow() {
		Set<String> windowHandles = getDriver().getWindowHandles();
		for (String str : windowHandles) {
			getDriver().switchTo().window(str);
		}
	}

	public void pause(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Author : ManimaranThis method double clicks over the given WebElement using
	 * Java Script
	 * 
	 * @param element
	 *            - WebElement
	 */
	public void doubleClickJS(WebElement element) {
		getExecutor().executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", element);
	}
	
	public String getParentWindow()
	{
		String parent=getDriver().getWindowHandle();
		return parent;
	}
	
	public void switchToWindowByHandle(String win) {
		getDriver().switchTo().window(win);
		
	}
	
	/**
	 * Method Name: getElement Author: Manimaran Return type: none Parameters: element
	 * Description: to click the element.
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElementShort(By locator) {
		WebElement ele = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, IMPLICITE_WAIT_S);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			ele = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (TimeoutException e1) {
			e1.printStackTrace();
		}
		return ele;

	}

	
	public void refreshPage()
	{
		getDriver().navigate().refresh();
	}
	
	/**
	 * 
	 * @param Session_id
	 */
	
	public void insertJavaScript(String Session_id)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript(String.format("localStorage.setItem('%s','%s');", "ls.token", Session_id));
	}
	
	/**
	 * This method will take fullpage screenshot of the webpage
	 * 
	 * @return
	 */
	public static Screenshot takeScreenShot() {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		return screenshot;
	}

	@Nullable
	public static File screenshotFile(Screenshot screenshot, String filename) {
		BufferedImage img = screenshot.getImage();
		File outputfile = new File(filename);

		try {
			ImageIO.write(img, "jpg", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputfile;
	}

	@Nullable
	private static byte[] screenshot2PNGArray(Screenshot screenshot) {
		BufferedImage img = screenshot.getImage();
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			ImageIO.write(img, "png", baos);
			baos.flush();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}

}

