package launcher;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC007 extends Launcher {
	public static void main(String[] args) throws IOException {
		init();
		
		launch("ChromeBrowser");
		
		navigateUrl("amazonUrl");
		// These methods are defined in diff way so see launcher n TC008 codes 
		
		//selectOption("searchDropdownBox","Books");
		//typetext("field-keywords","Harry Potter");
		//clickElement("//input[@id='nav-search-submit-button']");
		
	
	}

	
	}


