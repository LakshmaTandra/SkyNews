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
	

	@Given("I open the browser")
	public void i_open_the_browser()  {
	   System.out.println("Openning Browser");
 	   base.driver.manage().window().maximize();
	   
	}

	@When("I navigate to SkyNews homepage")
	public void i_navigate_to_sky_news_homepage() {
		System.out.println("Navigate to SkyNews homePage");
		try {
			base.driver.get(base.getProperty("url"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		homePage = new HomePage(base.driver);
		    
	}
	
	@And("I accept website cookies")
	public void i_accept_website_cookies() {
		homePage.acceptCookiesandSwithToDefaultPage();
	}
	

	@Then("Verify the browser title on home page")
	public void verify_the_browser_title_on_home_page() {
		System.out.println("Verify title of homepage.");
		Assert.assertTrue("Home Page Title did not match", homePage.verifyHomePageTitle());
	    
	}

	@Then("Verify All the categories on homepage are displayed")
	public void verify_the_all_the_categories_on_homepage_are_displayed() {
	    System.out.println("Verify All categories on home page.");
	   Assert.assertTrue("All categories on home page did not match", homePage.verifyCategoriesDisplayedOnHomePage());
	   
	    
	}

	@Then("Verify default category selected is Home")
	public void verify_default_category_selected_is_home() {
		System.out.println("Verify default category selected on home page.");
		Assert.assertTrue("Home category is not highlighted", homePage.isHomeCategoryHighLighted());
	    
	}

	@When("I click on Climate category")
	public void i_click_on_climate_category() {
	    System.out.println("Click on Climate category");
	    homePage.navigateToClimatePage(); 
	    
	}

	@Then("Verify Climate  category is highlighted")
	public void verify_climate_category_is_highlighted() {
		System.out.println("Verify climate is highlighted");
		climatePage = new ClimatePage(base.driver);		
		Assert.assertTrue(climatePage.isClimateCategoryHighLighted());
	   
	}

	@And("I click on any of the story on home page")
	public void i_click_on_any_of_the_story_on_home_page() {
		System.out.println("Click on a story");		
		storyWord = homePage.getWordFromStory(2);
		System.out.println(storyWord);
		homePage.clickOnStoryLink();
		
	    
	}

	@Then("Verify the title on the page matches the selected story on home page")
	public void verify_the_title_on_the_page_matches_the_selected_story_on_home_page() {
		System.out.println("Verify title of the page.");
		storyPage = new StoryPage(base.driver);	
		System.out.println(storyPage.verifyStoryPageTitleContainsAWord(storyWord));
		Assert.assertTrue(storyPage.verifyStoryPageTitleContainsAWord(storyWord));
		
	   
	}

	

}
