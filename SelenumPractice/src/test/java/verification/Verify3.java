package verification;

import java.io.IOException;

import com.aventstack.extentreports.Status;

import launcher.Launcher;

public class Verify3 extends Launcher {
	public static void main(String[] args) throws IOException {
		init();
		test = rep.createTest("Verify3");
		test.log(Status.INFO,"Init the properties file..... ");
		
		launch("ChromeBrowser");
		test.log(Status.INFO,"Launch the browser"+childProp.getProperty("ChromeBrowser"));
		
		navigateUrl("amazonUrl");
		test.log(Status.PASS,"Open the url"+childProp.getProperty("amazonUrl"));
		
		String expectedText="Customer Servic";
		
		if(!linkEqual(expectedText)) {
			reportFailure("Both text are not equals");
			
		}
		else 
			reportSucess("Both tet are equal");
		rep.flush();
	}

}
