package launcher;

import java.io.IOException;
//launching user defined profile browser

public class TC003 extends Launcher  {
	public static void main(String[] args) throws IOException {
		init();
		launch("FirefoxBrowser");
		navigateUrl("ICICI");
		System.out.println(driver.getTitle());
		
	}

}
