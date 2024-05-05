package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();

	
	public WebDriver initDriver(String browser) {
		System.out.println("browser value is:"+browser);
		
	if(	browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
				
		}
	
	else if(	browser.equals("edge")){
		WebDriverManager.chromedriver().setup();
		tlDriver.set(new EdgeDriver());
		
	}
	
	else if(	browser.equals("firefox")){
		WebDriverManager.chromedriver().setup();
		tlDriver.set(new FirefoxDriver());
	}
	else {
		System.out.println("Please pass correct browser value:"+browser);
	}

	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	
	return getDriver();
}
	
	//this is used to get the driver with ThreadLocal
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
	}
}

