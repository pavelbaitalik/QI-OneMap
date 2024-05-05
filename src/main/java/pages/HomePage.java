package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {


	public  WebDriver driver;
	final WebDriverWait wait;
	
	
	
	@FindBy(xpath="//*[@id='cesiumContainer']")
	WebElement homepageMapLocator;
	

	
	public HomePage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	
	}

	
	
	
}
