package launcher;

import java.io.IOException;

public class TC006 extends Launcher {
	public static void main(String[] args) throws IOException {
		init();
		launch("ChromeBrowser");
		navigateUrl("certificateUrl");
	}

}
