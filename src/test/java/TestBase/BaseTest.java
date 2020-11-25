package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseTest {

	public  WebDriver driver;

	Properties prop;
	
	
	
	public String getProperty(String propValue) throws IOException {
		
		FileReader fileReader = new FileReader("./src/test/resources/config.properties");
		
		prop = new Properties();
		
		prop.load(fileReader);
		
		return prop.getProperty(propValue);
	}
	
	
	public void captureScreenshot(String scenarioName) throws IOException {
		
		Date currentDate = new Date();
		String screenshotFilename = currentDate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("screenshot/"+scenarioName +"-"+screenshotFilename + ".png"));
	}
	
}
