package launcher;

import java.io.IOException;

import com.aventstack.extentreports.Status;

public class TC009 extends Launcher {
public static void main(String[] args) throws IOException {
	init();
	test = rep.createTest("TC009");
	test.log(Status.INFO,"Init the properties file..... ");
	
	launch("ChromeBrowser");
	test.log(Status.INFO,"Launch the browser"+childProp.getProperty("ChromeBrowser"));
	
	navigateUrl("amazonUrl");
	test.log(Status.PASS,"Open the url"+childProp.getProperty("amazonUrl"));
   // driver.findElement(getLocators("amazondropbox_id")).sendKeys("Books"); given wrong return statement i.e null..corrected to by
	
	selectOption("amazondropbox_id", "Books");
	test.log(Status.FAIL,"select the option by usiong locator "+loc.getProperty("amazondropbox_id"));
	
	typetext("amazonsearchtextbox_id", "Harry Potter");
	test.log(Status.PASS,"type the text in locator  "+loc.getProperty("amazonsearchtextbox_id"));
  
	clickElement("amazonsearchbutton_xpath");
    test.log(Status.PASS,"click the button by using the locator "+loc.getProperty("amazonsearchbutton_xpath"));
    
    rep.flush();
	
} {
	
}

}
