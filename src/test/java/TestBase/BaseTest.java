package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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
	
	
}
