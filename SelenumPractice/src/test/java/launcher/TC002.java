package launcher;

import java.io.IOException;


public class TC002 extends Launcher {
	
	public static void main(String[] args) throws IOException {
		init();
		launch("ChromeBrowser");
		navigateUrl("GoogleDoc");
		//String source=driver.getPageSource();
		//System.out.println(source);
		// selenium 4 features 
	
	System.out.println	(driver.getTitle());
	}

}
//