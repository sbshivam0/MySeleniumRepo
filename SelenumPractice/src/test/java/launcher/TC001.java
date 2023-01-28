package launcher;

public class TC001 extends BrowserLauncher {
	
	public static void main(String[] args) {
		launcher("Chrome");
		driver.get("https://www.google.com/docs/about/");
		
	}

}
