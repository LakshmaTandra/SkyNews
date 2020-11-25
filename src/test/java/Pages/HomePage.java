package Pages;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * class to interact with page
 * @author Lakshma
 *
 * This class has web elements of Home page which are used by SkyNewsHomepage
 */


public class HomePage extends PageBase {
	
	
	public HomePage(WebDriver driver) {
		
		super(driver);
		
	}

	String expectedHomePageTitle = "The Latest News from the UK and Around the World | Sky News";

	By _acceptCookiesCTA = By.xpath("//*[@title='Accept']");
	
	By _listOfCategories = By.xpath("//*[@class='sdc-site-header__menu-item' and @data-role='main-nav-item']");
	
	By _homeCategoryLink = By.xpath("//*[ @data-role='main-nav-item']/a[text()='Home']");
	
	By _climateCategoryLink =  By.linkText("Climate");
	
	By _storyTitle = By.xpath("//span[@class='sdc-site-tile__headline-text']");
	
	By _storyLink = By.xpath("//a[@class='sdc-site-tile__headline-link']");
	
	
	
	/*
	 * Method to accept cookies on homepage
	 */
	
	public void acceptCookiesandSwithToDefaultPage() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("sp_message_iframe_368417"));
		wait.until(ExpectedConditions.elementToBeClickable(_acceptCookiesCTA)).click();
     	driver.switchTo().defaultContent();
		
	}
	
	/*
	 * Method to verify Sky news home page title
	 */
	
	public Boolean verifyHomePageTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle.equals(expectedHomePageTitle);
	}
	
	
	/*
	 * Method to verify categories displayed on home page
	 */
	
	public Boolean verifyCategoriesDisplayedOnHomePage() {
		Boolean categoryFlag = true ;
		List<String> expectedCategories = new ArrayList<String>(Arrays.asList(
				                                  "Home","UK","World","Politics",
				                                   "US","Climate","Science & Tech",
				                                   "Business","Ents & Arts","Travel",
				                                   "Offbeat","Analysis", "Opinion","Videos","Weather",""));
		List<WebElement>  categories =driver.findElements(_listOfCategories);
		
		for(WebElement c : categories) {
			 System.out.println("Category: "+ c.getText());
			   if (!expectedCategories.contains(c.getText())) {
				   System.out.println(c.getText()+": Not Present in category list");
				   
				   categoryFlag = false;
				   break;
				   
				   }else{
					   categoryFlag=  true;
				   }	  
		}
		return categoryFlag;
	}
	
	
	/*
	 * Method returns a Boolean value if the home category field is highlighted on home page.
	 */
	
	public Boolean isHomeCategoryHighLighted() {
		
	return Boolean.parseBoolean(driver.findElement(_homeCategoryLink).getAttribute("aria-current"));
	
	}
	
	/*
	 * Method to navigate to climate page.
	 */
	
	
	public void navigateToClimatePage() {
	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(_climateCategoryLink)));	
	 driver.findElement(_climateCategoryLink).click();
	}
	
	/*
	 * Method returns the word present in the story at index i passed as parameter.
	 */
	
	public String getWordFromStory(int i) {
	 String[] Title = driver.findElement(_storyTitle).getText().split(" ");
		return Title[i];
	}
	
	
	/*
	 * Method to click on the story link. This method clicks on the first story link present on home page.
	 */
	
	public void clickOnStoryLink() {
		driver.findElement(_storyLink).click();
	}
	
}
