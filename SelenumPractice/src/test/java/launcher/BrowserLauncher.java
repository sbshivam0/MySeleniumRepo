package launcher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher {
	public static WebDriver driver;
    public static void launcher(String browser) {
			if(browser.contains("Chrome")) {
				WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
			if(browser.contains("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
		}
		
	

}
