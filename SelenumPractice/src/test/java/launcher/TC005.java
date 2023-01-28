package launcher;

import java.io.IOException;

public class TC005  extends Launcher {
	public static void main(String[] args) throws IOException {
		init();
		launch("ChromeBrowser");
		navigateUrl("GoogleDoc");
		if(driver.getTitle().equals( "Google Docs: Online Document Editor | Google Workspace")){
			System.out.println("test case passed ");
			
		}
		else {
			System.out.println("Test case failed ");
		}
		
		
		
		
		  
	}

}
