package WebDriverScreenshots;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy4 {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://www.google.com");
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		for(int i =0;i<links.size();i++) {
			String linkName=links.get(i).getAttribute("innerHTML");
			links.get(i).click();
			/*LocalDateTime t = LocalDateTime.now();
			String timeNow=t.toString().replace("-", "_");
			timeNow.replace(":", "_");
			System.out.println(timeNow);*/
			// didn't worked let's try new way on selfy5 class
			
			
			
			
			File srcFile=( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcFile, new File("C:\\Users\\SHIVAM\\Desktop\\Screenshot\\"+linkName+".png"));
			
			links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		}
	}

}
