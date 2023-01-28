package launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launcher {
	public static WebDriver driver ;
	public static Properties mainProp;
	public static Properties childProp;
	public static FileInputStream fis;
	public static Properties loc;
	
	public static ExtentReports rep;
	public static ExtentTest test;
	
	// we used this  for getting the current project path
	public static  String projectPath=System.getProperty("user.dir");
	
	public static void init() throws IOException {
		//navigating to environmental properties file 
		fis= new FileInputStream(projectPath+"/src/main/resources/env.properties");
		mainProp= new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");//it will store prod in variable e 
		//System.out.println(e);// the output will be prod 
		
		//now we well go to the prod file by using the gateway from the env properties file 
		fis = new FileInputStream(projectPath+"/src/main/resources/"+e+".properties");
		childProp= new Properties();
		childProp.load(fis);
		fis= new FileInputStream(projectPath+"/src/main/resources/loc.properties");
		loc = new Properties();
		loc.load(fis);
		String s= loc.getProperty("amazonsearchbutton_xpath");
		System.out.println(s);
		fis=new FileInputStream(projectPath+"/src/main/resources/log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		rep=ExtentManager.getInstance();
		
		}
	
	public static void launch(String browser) {
		if(childProp.getProperty(browser).contains("Chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			// for getting the user defined profile browser
			//option.addArguments("user-data-dir=C:\\Users\\SHIVAM\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 8");
			
			driver= new ChromeDriver(option);
			// for maximizing the browser 
			//option.addArguments("--start-maximized");
			
			//for disabling the notifications 
			option.addArguments("--disable-notifications");
			
			//for certificate errors 
			//option.addArguments("--ignore-certificate-errors-spki-list");
			
		}
		if(childProp.getProperty(browser).contains("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			// To launch user defined Profile we use ProfileIni and FirefoxProfile class to launch the user defined Profile ...
			 ProfilesIni p = new ProfilesIni();
			 FirefoxProfile profile= p.getProfile("SeleniumProfile");
			 //After selecting the the type of user defined Profile we will setup the new Profile and for that we will use firefoxOptions class  
			 
			 FirefoxOptions option = new FirefoxOptions();
			 option.setProfile(profile);
			 // to handle the notification in our user defined profile  we will use profile object and setPref method 
			//profile.setPreference("dom.webnotifications.enabled", false);//this will not work for selenium 4
			 
			// handling notification using FirefoxOptions class
			option.addPreference("dom.webnotifications.enabled", false);
			
			
			// handling certificates error 
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			
			// proxy setting in firefox 
		/*	profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "192.168.10.1");//ip address 
			profile.setPreference("network.proy,socks_port", 1744);*/
			
			 // we know that firefoxDriver is a overloaded constructor we can use this to launch the user defined browser
			 driver= new FirefoxDriver(option);
			}
			
	}
	public static void navigateUrl(String UrlKey)
	{
		driver.get(childProp.getProperty(UrlKey));
		}
	
	public static void clickElement(String locatorKey)
	{
		getElement(locatorKey).click();
	}

	public static void typetext(String locatorKey, String textValue)
	{
		getElement(locatorKey).sendKeys(textValue);
	}


	public static void selectOption(String locatorKey, String option)
	{
		getElement(locatorKey).sendKeys(option);
		
	}
	
public static WebElement getElement(String locatorKey) {
	WebElement element=null;
	// before this we need check whether element is present
	if(!(isElementPresent(locatorKey))){
		System.out.println("Element is not Present:"+locatorKey);
	}
	/*
	 * if(locatorKey.endsWith("id")) {
	 * element=driver.findElement(By.id(loc.getProperty(locatorKey))); } else
	 * if(locatorKey.endsWith("name")) { element =
	 * driver.findElement(By.name(loc.getProperty(locatorKey))); } else
	 * if(locatorKey.endsWith("class")) { element =
	 * driver.findElement(By.className(loc.getProperty(locatorKey))); } else
	 * if(locatorKey.endsWith("xpath")){ element =
	 * driver.findElement(By.xpath(loc.getProperty(locatorKey))); } else
	 * if(locatorKey.endsWith("css")) { element =
	 * driver.findElement(By.cssSelector(loc.getProperty(locatorKey))); } else
	 * if(locatorKey.endsWith("PartialLinkText")) { element =
	 * driver.findElement(By.partialLinkText(loc.getProperty(locatorKey))); } else
	 * if(locatorKey.endsWith("linkText")) { element =
	 * driver.findElement(By.linkText(loc.getProperty(locatorKey))); }
	 */
	element=driver.findElement(getLocators(locatorKey));
return element;
}
	
public static boolean isElementPresent(String locatorKey) {
	System.out.println("Checking for Element ..");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	try {
		
		/*
		 * if(locatorKey.endsWith("id")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(loc.getProperty(
		 * locatorKey)))); } 
		 * else if (locatorKey.endsWith("name")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(loc.
		 * getProperty(locatorKey)))); } 
		 * else if (locatorKey.endsWith("class")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(loc.
		 * getProperty(locatorKey)))); } 
		 * else if (locatorKey.endsWith("xpath")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loc.
		 * getProperty(locatorKey)))); } 
		 * else if (locatorKey.endsWith("css")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loc.
		 * getProperty(locatorKey)))); } 
		 * else if
		 * (locatorKey.endsWith("partialLinkText")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(loc
		 * .getProperty(locatorKey)))); } 
		 * else if (locatorKey.endsWith("linkText")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(loc.
		 * getProperty(locatorKey)))); }
		 */
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocators(locatorKey)));
	}
	catch(Exception e) {
		return false;
	}
	return true;

}
// we have created this getLocator method because we can see that by .id , by.names code is repeating we can avoid that many else if statement by doing this 
public static By getLocators( String locatorKey)
{
	By by = null;
	if(locatorKey.endsWith("id")) {
		by = By.id(loc.getProperty(locatorKey));
	}
	else if(locatorKey.endsWith("name")) {
		by=By.name(loc.getProperty(locatorKey));
	}
	else if(locatorKey.endsWith("class")) {
		by=By.className(loc.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("xpath")) {
			by=By.xpath(loc.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("css")) {
			by=By.cssSelector(loc.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("partialLinkText")) {
			by=By.partialLinkText(loc.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("linkText")) {
			by=By.linkText(loc.getProperty(locatorKey));
		}
	
	return by;
	
	}
public static boolean linkEqual(String expectedText) {
	String actualText=driver.findElement(By.linkText("Customer Service")).getText();
	if(actualText.equals(expectedText)) { 
		return true;
		}
	else 
		return false;
}
public static void reportSucess(String Sucessmsg) {
	test.log(Status.PASS,Sucessmsg);
}
public static void reportFailure(String failuremsg) throws IOException {
	test.log(Status.FAIL, failuremsg);
	takeScreenshot();
}

public static void takeScreenshot() throws IOException {
	Date dt = new Date();
	String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";
	
	System.out.println(dateFormat);
	
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(srcFile, new File(projectPath+"//failureshot//"+dateFormat));
	

	test.log(Status.INFO,"Screenshot----->"+test.addScreenCaptureFromPath(projectPath+"//failureshot//"+dateFormat));
}
}





