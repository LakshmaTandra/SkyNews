Feature: SkyNews.com hompage page categories and story links.

Background:
Given I navigate to SkyNews homepage
When I accept website cookies

@Regression
Scenario: Verify the browser tab’s title on SkyNews.com
Then Verify the browser title on home page

@Regression
Scenario: Verify the number of categories displayed and their names on SkyNews home page.
Then Verify All the categories on homepage are displayed

@Regression
Scenario: Verify the default focus point is on the Home category.
Then Verify default category selected is Home

@Regression
Scenario: Verify that if the user then clicks on ‘Climate’, this becomes the focus.
And I click on Climate category
Then Verify Climate  category is highlighted

@Regression
Scenario:Select a story from the homepage. Verify that a word of your choice in the title text of the
article you have just selected appears once title of the new page loads.
And I click on any of the story on home page
Then Verify the title on the page matches the selected story on home page



