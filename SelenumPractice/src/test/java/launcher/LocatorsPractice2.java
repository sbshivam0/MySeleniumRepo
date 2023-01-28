package launcher;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsPractice2 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://datatables.net/");
	
	int pageSize= driver.findElements(By.cssSelector("div#example_paginate>span>a")).size();
	for(int i=1;i<=pageSize;i++) {
		String pageSelect= "div#example_paginate>span>a:nth-child("+i+")";
		driver.findElement(By.cssSelector(pageSelect)).click();
		List<WebElement> names = driver.findElements(By.cssSelector("table#example>tbody>tr>td:first-child"));
		for(WebElement e:names) {
			System.out.println(e.getText());
		}
		
	}
}
}
