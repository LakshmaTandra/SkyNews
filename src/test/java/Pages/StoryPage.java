package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * class to interact with page
 * @author Lakshma
 *
 * This class has web elements of Story page which are used by SkyNewsHomepage
 */

public class StoryPage extends PageBase {
	
	
    public StoryPage(WebDriver driver) {
		super(driver);
	}
    
    
    /*
     * Method returns a boolean flag if the String passed into the method is present in the page title.
     */
    

	public Boolean verifyStoryPageTitleContainsAWord(String storyWord) {
		
		System.out.println(driver.getTitle());
		return wait.until(ExpectedConditions.titleContains(storyWord));
		
	
	}
	
}
