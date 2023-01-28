package launcher;

import java.io.IOException;

public class TC004 extends Launcher{
	public static void main(String[] args) throws IOException {
		init();
		launch("FirefoxBrowser");
		navigateUrl("certificateUrl");
		
	}

}
