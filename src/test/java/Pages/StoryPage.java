package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StoryPage extends PageBase {
	
	
    public StoryPage(WebDriver driver) {
		super(driver);
	}

	public Boolean verifyStoryPageTitleContainsAWord(String storyWord) {
		
		System.out.println(driver.getTitle());
		return wait.until(ExpectedConditions.titleContains(storyWord));
		
	
	}
	
}
