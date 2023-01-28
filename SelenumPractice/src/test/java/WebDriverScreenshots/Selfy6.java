package WebDriverScreenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy6 {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	
	driver.get("https://www.google.com");
	
	WebElement searchBar = driver.findElement(By.xpath("//div[@class='RNNXgb']"));
	
	File srcFile = searchBar.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(srcFile,new File("C:\\\\Users\\\\SHIVAM\\\\Desktop\\\\Screenshot\\searchBar.png"));
}
}
