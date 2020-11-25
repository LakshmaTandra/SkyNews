package StepDefinitions;


import java.io.IOException;

import org.junit.Assert;

import Pages.ClimatePage;
import Pages.HomePage;
import Pages.StoryPage;
import TestBase.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class SkyNewsHomePage extends BaseTest{

	private BaseTest base;
	String[] storyText;
	String storyPageTitle;
	String storyWord;
	HomePage homePage;
	ClimatePage climatePage;
	StoryPage storyPage;
	

	public SkyNewsHomePage(BaseTest base) {
		this.base = base;
	}

	/*
	 * method to navigate to sky news url and maximize the window.
	 */
	@Given("I navigate to SkyNews homepage")
	public void i_navigate_to_sky_news_homepage() {
		try {
			base.driver.manage().window().maximize();
			base.driver.get(base.getProperty("url"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		homePage = new HomePage(base.driver);
		    
	}
	
	
	/*
	 * method to accept cookies on home page
	 */
	
	@When("I accept website cookies")
	public void i_accept_website_cookies() {
		homePage.acceptCookiesandSwithToDefaultPage();
	}
	

	/*
	 * method to verify browser title
	 */
	@Then("Verify the browser title on home page")
	public void verify_the_browser_title_on_home_page() {
		Assert.assertTrue("Home Page Title did not match", homePage.verifyHomePageTitle());
	    
	}

	/*
	 * method to verify all categories displayed on home page
	 */
	@Then("Verify All the categories on homepage are displayed")
	public void verify_the_all_the_categories_on_homepage_are_displayed() {
	   Assert.assertTrue("All categories on home page did not match", homePage.verifyCategoriesDisplayedOnHomePage());
	   
	    
	}

	/*
	 * method to verify is the default category selected is home.
	 */
	@Then("Verify default category selected is Home")
	public void verify_default_category_selected_is_home() {
		Assert.assertTrue("Home category is not highlighted", homePage.isHomeCategoryHighLighted());
	    
	}
	
	/*
	 * method to click on climate link to navigate to climate page
	 */
	@When("I click on Climate category")
	public void i_click_on_climate_category() {
	    homePage.navigateToClimatePage(); 
	    
	}

	
	/*
	 * method to verify if climate category is highlighted
	 */
	@Then("Verify Climate  category is highlighted")
	public void verify_climate_category_is_highlighted() {
		climatePage = new ClimatePage(base.driver);		
		Assert.assertTrue(climatePage.isClimateCategoryHighLighted());
	   
	}

	/*
	 * method to click on first story on home page. This also captures the THIRD  word present on the story link.
	 */
	@And("I click on any of the story on home page")
	public void i_click_on_any_of_the_story_on_home_page() {
		storyWord = homePage.getWordFromStory(2);
		System.out.println(storyWord);
		homePage.clickOnStoryLink();
		
	    
	}

	/*
	 * method to verify if the word captured in the above method is present in the story title page.
	 */
	@Then("Verify the title on the page matches the selected story on home page")
	public void verify_the_title_on_the_page_matches_the_selected_story_on_home_page() {
		storyPage = new StoryPage(base.driver);	
		System.out.println(storyPage.verifyStoryPageTitleContainsAWord(storyWord));
		Assert.assertTrue(storyPage.verifyStoryPageTitleContainsAWord(storyWord));
		
	   
	}

	

}
