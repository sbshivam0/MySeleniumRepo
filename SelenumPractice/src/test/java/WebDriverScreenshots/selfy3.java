package WebDriverScreenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selfy3 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.google.com");
	
	String imgLink= driver.findElement(By.linkText("Images")).getText();
	System.out.println(imgLink);
	
	System.out.println("===================================");
	
	// we want all the link from the website 
	List<WebElement> link1=driver.findElements(By.tagName("a"));
	
	for(int i =0;i<link1.size();i++) {
		String link = link1.get(i).getText();
		System.out.println(link);
	}
	System.out.println("=====================================");
	List<WebElement> link2=driver.findElements(By.tagName("a"));
	

	for(int i =0;i<link2.size();i++) {
		String link = link2.get(i).getAttribute("innerHTML");
		System.out.println(link);
	}
	
	
}

}
