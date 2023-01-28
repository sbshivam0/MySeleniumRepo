package launcher;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class TC008 extends Launcher{
	private static final Logger  log = Logger.getLogger(TC008.class);
		
	
	public static void main(String[] args) throws IOException {
		init();
		log.info("Init the properties file..... ");
		
		launch("ChromeBrowser");
		log.info("Launch the browser"+childProp.getProperty("ChromeBrowser"));
		
		navigateUrl("amazonUrl");
		log.info("Open the url"+childProp.getProperty("amazonUrl"));
	   // driver.findElement(getLocators("amazondropbox_id")).sendKeys("Books"); given wrong return statement i.e null..corrected to by
		
		selectOption("amazondropbox_id", "Books");
		log.info("select the option by usiong locator "+loc.getProperty("amazondropbox_id"));
		
		typetext("amazonsearchtextbox_id", "Harry Potter");
		log.info("type the text in locator  "+loc.getProperty("amazonsearchtextbox_id"));
	  
		clickElement("amazonsearchbutton_xpath");
	    log.info("click the button by using the locator "+loc.getProperty("amazonsearchbutton_xpath"));
		//getElement("amazondropbox_id").sendKeys("Books"); missed to type return type element= driver. in getElement() in launcher class
	}

}
