package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * class to interact with page
 * @author Lakshma
 *
 * This class has web driver used by page classes
 */


public class PageBase {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,20);
	}

}
