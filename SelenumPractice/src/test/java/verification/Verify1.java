package verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com");
		
		//String actualText=driver.findElement(By.linkText("Customer Service")).getText();
		String actualText=driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		String expectedText="Customer Ser";
		
		//if(actualText.equals(expectedText)) 
		//if(actualText.contains(expectedText))
	    if(actualText.toLowerCase().contains(expectedText.toLowerCase()))
		{
			System.out.println("Both text are equal");
		}
		else {
			System.out.println("Both text are not equal");
		}
	
		
	}

}
