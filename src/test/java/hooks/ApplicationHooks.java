package hooks;


import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;

public class ApplicationHooks {
	
	private ConfigReader configReader;
	private WebDriver driver;
	private DriverFactory driverFactory;
	public static Properties properties;
	
	@Before(order = 0)
	public void getProperty()
	{
		configReader=new ConfigReader();
		properties=configReader.init_Properties();
		
	}
	     
	@Before(order = 1)
	public void launchBrowser()
	{
		String browserName=properties.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.initDriver(browserName);
		
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
		
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			//take screenshot
			
			String screenShotName=scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcePath, "image/png", screenShotName);
						
		}
	}

}