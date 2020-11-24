package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClimatePage extends PageBase{
	
	
	public ClimatePage(WebDriver driver) {
		super(driver);
	  }

	By climateCategoryLink = By.xpath("//*[ @data-role='main-nav-item']/a[text()='Climate']");
	
	public Boolean isClimateCategoryHighLighted() {
		wait.until((ExpectedConditions.presenceOfElementLocated(climateCategoryLink)));
		
		System.out.println(driver.findElement(climateCategoryLink).getAttribute("aria-current"));
		
		return Boolean.parseBoolean(driver.findElement( climateCategoryLink).getAttribute("aria-current"));
		
		}
}
