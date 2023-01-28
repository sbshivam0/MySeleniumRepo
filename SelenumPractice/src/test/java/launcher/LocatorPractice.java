package launcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorPractice {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://money.rediff.com/gainers");
		
		String currentPrice=driver.findElement(By.xpath("//a[contains(text(),'Lambodhara')]/parent::*/following-sibling::td[3]")).getText();
		
		System.out.println(currentPrice);
		driver.quit();
	}
	

}
