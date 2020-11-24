package StepDefinitions;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestBase.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupAndTearDown extends BaseTest{
	
		
	private BaseTest base;
	

	public SetupAndTearDown(BaseTest base) {
		this.base = base;
	}



	@Before
	public void setUp() {
		String browser;
		try {
			browser = base.getProperty("browser");

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				base.driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				base.driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				base.driver = new EdgeDriver();
			} else {
				System.out.println(" Enter correct browser details");
				throw new Exception("Enter correct browser details");

			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@After
	public void tearDown() {
		base.driver.close();
		
	}
	
	
}
